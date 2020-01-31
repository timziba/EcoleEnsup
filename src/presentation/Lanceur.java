package presentation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import metier.Etudiant;
import metier.Personne;

public class Lanceur {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Date dateformat = null;
		
		List<Etudiant> list= getListEtudiant();
		
		for (Etudiant etudiant : list) {
			System.out.println(etudiant.getNomPersonne() + " "+ etudiant.getPrenomPersonne());
		}
		
				
		Etudiant etudiant = new Etudiant();
		etudiant.setNomPersonne("diatta");
		etudiant.setPrenomPersonne("ema");
		etudiant.setAdressePersonne("sdfghjk");
		etudiant.setEmailPersonne("edrtyu");
		etudiant.setNumeroPersonne("esxdrcfv");
		etudiant.setDatenaissance(dateformat.valueOf("1998-06-11"));
		createEtudiant(etudiant);
		updateEtudiant(1," guyancourt");
		Boolean resultat = deleteEtudiant(2);
		if(resultat==true) {
			System.out.println("etudiant supprimer");
		}
		else {
			System.out.println("etudiant non supprimer");

		}
		//getEcole();
		
		Etudiant etudiant1 = getEtudiant("awa");
		System.out.println(etudiant1.toString());
		EtudiantCours("awa", "gtm");
		EtudiantCours("awa", "droit");
		
	}
	
public static void createEtudiant(Etudiant etudiant) {
		
		// information de la base de donnee
		
		String url = "jdbc:mysql://localhost/gestion_etablissement";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		
		try {
			// etape1 chargement du driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// etape2 recupertion de la connnexion
			
			cn = DriverManager.getConnection(url, login, password);
			
			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `etudiant`(`nomEtudiant`,`prenomEtudiant`,`emailEtudiant`,`adresseEtudiant`,`numeroEtudiant`,`datenaissance`) VALUES ('"+etudiant.getNomPersonne()+"','"+etudiant.getPrenomPersonne()+"','"+etudiant.getEmailPersonne()+"','"+etudiant.getAdressePersonne()+"','"+etudiant.getNumeroPersonne()+"','"+etudiant.getDatenaissance()+"')";
			//etape 4 executer la requette
			st.executeUpdate(sql);
			System.out.println("Enrégistrement effectué avec succès !!!! ");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			
			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void getEcole() {
		
		// information de la base de donnee
		
				String url = "jdbc:mysql://localhost/gestion_etablissement";
				String login = "root";
				String password = "";
				Connection cn = null;
				Statement st = null;
				ResultSet rs = null;
				
				try {
					// etape1 chargement du driver
					
					Class.forName("com.mysql.jdbc.Driver");
					
					// etape2 recupertion de la connnexion
					
					cn = DriverManager.getConnection(url, login, password);
					
					// etape 3 creation du statement
					st = cn.createStatement();
					String sql = "select * from ecole";
					
					//etape 4 executer la requette
					System.out.println("Liste des ecoles ");
					rs = st.executeQuery(sql);		
					
					//etape5 parcours du resultSet
					while (rs.next()) {
						System.out.print(rs.getString("idEcole"));
						System.out.print(" ");
						System.out.println(rs.getString("nomEcole"));
					}
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				finally {
					
					// etape 5 liberer les ressources
					try {
						cn.close();
						st.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				
	}	
	
public static Etudiant getEtudiant(String prenom) {
		
		// information de la base de donnee
		
				String url = "jdbc:mysql://localhost/gestion_etablissement";
				String login = "root";
				String password = "";
				Connection cn = null;
				Statement st = null;
				ResultSet rs = null;
				
				Etudiant etudiant = null;
				try {
					// etape1 chargement du driver
					
					Class.forName("com.mysql.jdbc.Driver");
					
					// etape2 recupertion de la connnexion
					
					cn = DriverManager.getConnection(url, login, password);
					
					// etape 3 creation du statement
					st = cn.createStatement();
					String sql = "select * from etudiant where prenomEtudiant = '"+prenom+"'";
					
					//etape 4 executer la requette
					System.out.println("Informations etudiant ");
					rs = st.executeQuery(sql);		
					
					//etape5 parcours du resultSet
					while (rs.next()) {
						etudiant = new Etudiant();
						etudiant.setNomPersonne(rs.getString("nomEtudiant"));
						etudiant.setPrenomPersonne(rs.getString("prenomEtudiant"));
						etudiant.setAdressePersonne(rs.getString("adresseEtudiant"));
						etudiant.setEmailPersonne(rs.getString("emailEtudiant"));
						etudiant.setDatenaissance(rs.getDate("datenaissance"));
						etudiant.setNumeroPersonne(rs.getString("datenaissance"));
						
					}
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				finally {
					
					// etape 5 liberer les ressources
					try {
						cn.close();
						st.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				return etudiant;
				
	}	
	public static ArrayList<Etudiant> getListEtudiant() {
		
		// information de la base de donnee
		
				String url = "jdbc:mysql://localhost/gestion_etablissement";
				String login = "root";
				String password = "";
				Connection cn = null;
				Statement st = null;
				ResultSet rs = null;
				
				ArrayList<Etudiant> listEtudiant = null;
				Etudiant etudiant = null;
				
				try {
					// etape1 chargement du driver
					
					Class.forName("com.mysql.jdbc.Driver");
					
					// etape2 recupertion de la connnexion
					
					cn = DriverManager.getConnection(url, login, password);
					
					// etape 3 creation du statement
					st = cn.createStatement();
					String sql = "select * from etudiant";
					
					//etape 4 executer la requette
					System.out.println("Liste des etudiants ");
					rs = st.executeQuery(sql);		
					
					//etape5 parcours du resultSet
					listEtudiant = new ArrayList<Etudiant>();
					while (rs.next()) {
						etudiant = new Etudiant();
						etudiant.setNomPersonne(rs.getString("nomEtudiant"));
						etudiant.setPrenomPersonne(rs.getString("prenomEtudiant"));
						listEtudiant.add(etudiant);
					}
				}
					catch (SQLException e) {
					
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				finally {
					
					// etape 5 liberer les ressources
					try {
						cn.close();
						st.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				
				return listEtudiant;
				
	}
	
	public static void updateEtudiant(int id , String adresse) {
		// information de la base de donnee
		
		String url = "jdbc:mysql://localhost/gestion_etablissement";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		
		try {
			// etape1 chargement du driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// etape2 recupertion de la connnexion
			
			cn = DriverManager.getConnection(url, login, password);
			
			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "update  etudiant set adresseEtudiant = '"+adresse+"' where idEtudiant = "+id;
			//etape 4 executer la requette
			System.out.println("modification.........");
			int rs=st.executeUpdate(sql);
			if(rs==1) {
				System.out.println("etudiant modifier");
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			
			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	public static Boolean deleteEtudiant(int id) {
		// information de la base de donnee
		
				String url = "jdbc:mysql://localhost/gestion_etablissement";
				String login = "root";
				String password = "";
				Connection cn = null;
				Statement st = null;
				
				try {
					// etape1 chargement du driver
					
					Class.forName("com.mysql.jdbc.Driver");
					
					// etape2 recupertion de la connnexion
					
					cn = DriverManager.getConnection(url, login, password);
					
					// etape 3 creation du statement
					st = cn.createStatement();
					String sql = "delete from   etudiant where idEtudiant = "+id;
					//etape 4 executer la requette
					System.out.println("suppression....");
					int rs=st.executeUpdate(sql);		
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				finally {
					
					// etape 5 liberer les ressources
					try {
						cn.close();
						st.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				
		return true;
		
	}
	
	public static void EtudiantCours(String prenom , String cours) {
		// information de la base de donnee
		
				String url = "jdbc:mysql://localhost/gestion_etablissement";
				String login = "root";
				String password = "";
				Connection cn = null;
				Statement st = null;
				ResultSet rs = null;
		
				
				try {
					// etape1 chargement du driver
					
					Class.forName("com.mysql.jdbc.Driver");
					
					// etape2 recupertion de la connnexion
					
					cn = DriverManager.getConnection(url, login, password);
					
					// etape 3 creation du statement
					st = cn.createStatement();
					String sql1="select idEtudiant from etudiant where prenomEtudiant ='"+prenom+"'";
					rs = st.executeQuery(sql1);
					int idetudiant = 0;
					while (rs.next()) {
						idetudiant = rs.getInt(1);
						
					}
					
					String sql2="select idCours from cours where theme ='"+cours+"'";
					rs = st.executeQuery(sql2);
					int idcours = 0;
					while (rs.next()) {
						idcours = rs.getInt(1);
						
					}
					String sql = "insert into `detailscours`(`idcours`,`idetudiant`) VALUES ('"+ idcours+"','"+ idetudiant+"')";
							//etape 4 executer la requette
					//etape 4 executer la requette
					
					int resultat = st.executeUpdate(sql);	
					if(resultat==1) {
						System.out.println("l'etudiant  " + prenom+" est associer au cours  " + cours+ "");
					}
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				finally {
					
					// etape 5 liberer les ressources
					try {
						cn.close();
						st.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				
		
		
	}


}
