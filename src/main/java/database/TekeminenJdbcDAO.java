package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tekeminen;

// TekeminenJdbcDAO-luokka toteuttaa TekeminenDAO-rajapinnan palvelut

public class TekeminenJdbcDAO implements TekeminenDAO {

	// Hakee tietokannan taulusta tekemiset ja luo ja palauttaa tiedot Tekeminen-tyyppisten olioiden listana
	
	public List<Tekeminen> findAll() {
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
		ResultSet resultset = null;   // select-lauseen tulostaulu
		
		List<Tekeminen> tekemiset = new ArrayList<Tekeminen>(); // luodaan tyhjä lista
		Tekeminen tekeminen = null;
		
		try {
			connection = Database.getDBConnection(); // Luodaan yhteys
			String sqlSelect = 
					"SELECT id, nimi, kuvaus, sijainti FROM todo;"; 	// Luodaan komento: haetaan kaikki rivit todo-taulusta
			statement = connection.prepareStatement(sqlSelect); // Valmistellaan komento:
			resultset = statement.executeQuery(); // Lähetetään select-komento suoritettavaksi tietokantapalvelimelle:
			
			while (resultset.next()) {
				tekeminen = readTekeminen(resultset); // Käydään tulostaulun rivit läpi ja luetaan readTekeminen()-metodilla
				tekemiset.add(tekeminen); // lisätään tekeminen listaan
			}
		}  catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(resultset, statement, connection); // SULJETAAN YHTEYS!!
		}
		return tekemiset;
		
	}
	
	public Tekeminen findById(int id) {
		Connection connection = null;  // tietokantayhteys
		PreparedStatement statement = null;  // sql-lause
		ResultSet resultset = null;   // select-lauseen tulostaulu
		Tekeminen tekeminen = null;
		
		try {
			connection = Database.getDBConnection(); // Luodaan yhteys
			String sqlSelect = "SELECT id, nimi, kuvaus, sijainti FROM todo WHERE id = ?;"; // Luodaan sql komento
			statement = connection.prepareStatement(sqlSelect); // Valmistellaan komento
			statement.setInt(1, id);
			resultset = statement.executeQuery(); // Lähetetään select-komento suoritettavaksi tietokantapalvelimelle:
			
			if (resultset.next()) {
				tekeminen = readTekeminen(resultset);
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		finally {
			Database.closeDBConnection(resultset, statement, connection);
		}
		
		return tekeminen;
		
	}
	
	private Tekeminen readTekeminen(ResultSet resultset) {
		try {
			// Haetaan yhden tekeminen tiedot kyselyn tulostaulun (ResultSet-tyyppinen resultset-olion) aktiiviselta tietoriviltä
			int id = resultset.getInt("id");
			String nimi = resultset.getString("nimi");
			String kuvaus = resultset.getString("kuvaus");
			String sijainti = resultset.getString("sijainti");
			
			// Luodaan ja palautetaan uusi Tekeminen-luokan olio
			return new Tekeminen(id, nimi, kuvaus, sijainti);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
}

	public boolean addTekeminen(Tekeminen tekeminen) {
		Connection connection = null;  // tietokantayhteys
		PreparedStatement stmInsert = null;  // sql-lause
		boolean updateSuccessed = false; // kokeilaan onnistuminen
		
		try {
			connection = Database.getDBConnection(); // Luodaan yhteys
			String sqlInsert = "INSERT INTO todo (nimi, kuvaus, sijainti) VALUES (?, ?, ?);"; // luodaan komento: luodaan uusi tekeminen tietokantaan
			stmInsert = connection.prepareStatement(sqlInsert); // valmistellaan komento
			stmInsert.setString(1, tekeminen.getNimi());
			stmInsert.setString(2, tekeminen.getKuvaus());
			stmInsert.setString(3, tekeminen.getSijainti());
			int rowAffected = stmInsert.executeUpdate();
			
			if (rowAffected == 1) updateSuccessed = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmInsert, connection); // SULJETAAN YHTEYS!
		}
		return updateSuccessed;
	}

	public boolean removeTekeminen(int tekeminenId) {
		Connection connection = null; // tietokantayhteys
		PreparedStatement stmDelete = null; // sql-lause
		boolean updateSuccessed = false; // kokeillaan onnistumista
		
		try {
			connection = Database.getDBConnection(); // luodaan yhteys tietokantaan
			String sqlDelete = "DELETE FROM todo WHERE id = ?;"; // luodaan tietokanta komento
			stmDelete = connection.prepareStatement(sqlDelete); // valmistellaan komento
			stmDelete.setInt(1, tekeminenId);
			int rowAffected = stmDelete.executeUpdate();
			
			if (rowAffected == 1) {
				updateSuccessed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmDelete, connection); // SULJETAAN YHTEYS!
		}
		
		return updateSuccessed;
	}
	
	
	public boolean editTekeminen(Tekeminen tekeminen) {
		Connection connection = null; // tietokantayhteys
		PreparedStatement stmUpdate = null; // sql-lause
		boolean updateSuccessed = false; // kokeillaan onnistumista
		
		try {
			connection = Database.getDBConnection(); // luodaan yhteys tietokantaan
			String sqlUpdate = "UPDATE todo SET nimi = ?, kuvaus = ?, sijainti = ? WHERE id = ?;"; // luodaan tietokanta komento
			stmUpdate = connection.prepareStatement(sqlUpdate); // valmistellaan komento
			
			stmUpdate.setString(1, tekeminen.getNimi());
			stmUpdate.setString(2, tekeminen.getKuvaus());
			stmUpdate.setString(3, tekeminen.getSijainti());
			stmUpdate.setInt(4, tekeminen.getId());
			int rowAffected = stmUpdate.executeUpdate();
						
			if (rowAffected == 1) {
				updateSuccessed = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmUpdate, connection); // SULJETAAN YHTEYS!
		}
		
		return updateSuccessed;
	}
	
	public List<Tekeminen> haeRandomTekeminen() {
			Connection connection = null;  // tietokantayhteys
			PreparedStatement statement = null;  // sql-lause
			ResultSet resultset = null;   // select-lauseen tulostaulu
			
			List<Tekeminen> tekemiset = new ArrayList<Tekeminen>(); // luodaan tyhjä lista
			Tekeminen tekeminen = null;
			
			try {
				connection = Database.getDBConnection(); // Luodaan yhteys
				String sqlSelect = 
						"SELECT * FROM todo order by rand() limit 1;"; 	// Luodaan komento: haetaan kaikki rivit todo-taulusta
				statement = connection.prepareStatement(sqlSelect); // Valmistellaan komento:
				resultset = statement.executeQuery(); // Lähetetään select-komento suoritettavaksi tietokantapalvelimelle:
				
				while (resultset.next()) {
					tekeminen = readTekeminen(resultset); // Käydään tulostaulun rivit läpi ja luetaan readTekeminen()-metodilla
					tekemiset.add(tekeminen); // lisätään tekeminen listaan
				}
			}  catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				Database.closeDBConnection(resultset, statement, connection); // SULJETAAN YHTEYS!!
			}
			return tekemiset;
			
		}
	
}