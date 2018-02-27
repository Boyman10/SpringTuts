package com.spring.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("offersDAO")
public class OffersDAO {

	private JdbcTemplate jdbc;
	


	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers() {
		
		return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {


				Offer offer = new Offer();
				
				offer.setId(arg0.getInt("id"));
				offer.setName(arg0.getString("name"));
				offer.setText(arg0.getString("text"));
				offer.setEmail(arg0.getString("email"));
				
				return offer;
				
			}
			
			
		});
		
	}

}
