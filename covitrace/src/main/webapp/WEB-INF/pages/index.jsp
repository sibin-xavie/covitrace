<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p><br/>
 <form action="authenticateUserService">
                                    <ol>
                                        <li>
                                            <label for="name">Username </label>
                                            <input id="username" name="username" style="width: 300px;" />
                                        </li>
                                        <li>
                                            <label for="password">Password </label>
                                            <input type="password" id="password" name="password" style="width: 300px;" />
                                        </li>
                                        <br />
                                        <li>
                                            <input value="Submit" type="submit" />
                                        </li>

                                    </ol>
                                </form>


</p>
</body>
</html>