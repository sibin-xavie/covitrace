package com.jea.medico.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "meet_log")
public class MeetLogModel {
	
	
		@Id
		@GeneratedValue
		@Column(name = "meet_id")
		private int meetId;
		@Column(name = "meet_start_time",length = 100 )
		private Time meetStartTime;
		@Column(name = "meet_end_time",length = 100 )
		private Time meetEndTime;
		@Column(name = "meet_date",length = 100 )
		private Date meetDate;
		@OneToOne
		@JoinColumn(name = "user_id")
		private UserMasterModel userId; 
}
