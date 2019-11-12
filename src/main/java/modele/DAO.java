/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DAO {
    
   	protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        public int addDiscountCode(String code,float taux) throws Exception{
            String sql = "INSERT INTO DISCOUNT_CODE VALUES (?,?)";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setString(1, code);
                        stmt.setFloat(2, taux);
			
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
        }
        public int deleteDiscountCode(String code) throws Exception{
            String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setString(1, code);
			
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
        }        
        
        public List<CodeEntity> getDiscount_Code() throws Exception{
            	List<CodeEntity> result = new ArrayList<>();

		String sql = "SELECT * FROM DISCOUNT_CODE WHERE DISCOUNT_CODE";
		try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()){
                            result.add(new CodeEntity(rs.getString("DISCOUNT_CODE"),rs.getFloat("RATE")));
                        }
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                        throw new Exception(ex.getMessage());
                        } 
		return result;
        }                 
}
