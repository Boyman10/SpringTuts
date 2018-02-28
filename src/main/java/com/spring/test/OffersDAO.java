package com.spring.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDAO")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;
	


	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers() {
		
		MapSqlParameterSource params = new MapSqlParameterSource("name", "Bob%");
		//params.addValue(paramName, value);
		
		return jdbc.query("SELECT * FROM offers WHERE name LIKE :name", params, new RowMapper<Offer>() {

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
