package com.jea.medico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfigurer {
    @Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Configuration
    @Order(1)
    public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    	@Bean
    	public PasswordEncoder passwordEncoder() {
    		return new BCryptPasswordEncoder();
    	}

    	@Bean
    	@Override
    	public AuthenticationManager authenticationManagerBean() throws Exception {
    		return super.authenticationManagerBean();
    	}

    	@Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    				auth.authenticationProvider(customAuthenticationProvider);
    				
                    auth
                        .userDetailsService(jwtUserDetailsService)
                        .passwordEncoder(passwordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.
            		antMatcher("/api/v1/**").authorizeRequests()
                    	//.antMatchers("/api/v1/**").permitAll()
    	                .antMatchers("/api/v1/patientRegisterService").permitAll()
    	                .antMatchers("/api/v1/authenticateUserService").permitAll()
    	                .antMatchers("/api/v1/admin/**").hasAuthority("ADMIN")
    	                .antMatchers("/api/v1/user/**").hasAuthority("USER")
                    .anyRequest()
                    .authenticated().and()
                    .addFilterBefore(jwtRequestFilter,
                            UsernamePasswordAuthenticationFilter.class)
                    .csrf().disable()
                    .exceptionHandling();//.authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                    //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            
    		// Add a filter to validate the tokens with every request
    		//http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        }
    }

    @Configuration
    @Order(2)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Autowired
        private UserDetailsService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                    auth
                        .userDetailsService(userDetailsService)
                        .passwordEncoder(bCryptPasswordEncoder);
        }
        
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.
	            authorizeRequests()
	                .antMatchers("/web/**").permitAll()
	                .antMatchers("/web/login").permitAll()
	                .antMatchers("/web/registration").permitAll()
	                .antMatchers("/web/admin/**").hasAuthority("ADMIN")
	                .antMatchers("/web/user/**").hasAuthority("USER")
	            .anyRequest()
	            .authenticated()
	            .and().csrf().disable()
	                .formLogin()
	                .loginPage("/web/login")
	                .failureUrl("/web/login?error=true")
	                .defaultSuccessUrl("/web//default")
	                .usernameParameter("user_name")
	                .passwordParameter("password")
	            .and().logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/web/logout"))
	            .logoutSuccessUrl("/web/login").and().exceptionHandling();
        }
        
        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
        }

    }
}
