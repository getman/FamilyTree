package getman.family_tree.model;

/**Represents a client connection with database
 * @author getman
 * @since 17.04.14
 * @version 0.1*/
public abstract class DBClient {
	//-----------Data members------------
	/**Data base connection parameters built on place*/
	private static final DBConnectionParams mDBConnectionParams = new DBConnectionParams.
		DBConnectionParamsBuilder().hostName("127.0.0.1").portNumber("5432").dbName("family_tree").
		userName("getman").password("12345678").buildDBConnectionParams();
	
	//----------Methods-----------
	/**Requests data from DB*/
	public abstract void requestObject();
	
	//--------------Nested classes---------------
	/**Represents database connection parameters
	 * @author getman
	 * @since 17.04.14
	 * @version 0.1*/
	static class DBConnectionParams{
		//----------Data members------------
		private String mHostName = null;
		private String mPortNumber = null;
		private String mDBName = null;
		private String mUserName = null;
		private String mPassword = null;
		
		//------------Nested classes------------
		/**Represents DBConnectionParams builder according Builder pattern
		 * @author getman
		 * @since 17.04.14
		 * @version 0.1*/
		public static class DBConnectionParamsBuilder{
			//-----------Data members------------
			private String mHostName = null;
			private String mPortNumber = null;
			private String mDBName = null;
			private String mUserName = null;
			private String mPassword = null;
			
			//-----------Methods------------
			/**Sets up the builder object data base host name
			 * @param hostName {@link String} new database host name
			 * @return {@link DBConnectionParams} builder object*/
			public DBConnectionParamsBuilder hostName(String hostName){
				this.mHostName = hostName;
				return this;
			}
			
			/**Sets up the builder object data base port number
			 * @param portNumber {@link String} new database port number
			 * @return {@link DBConnectionParams} builder object*/
			public DBConnectionParamsBuilder portNumber(String portNumber){
				this.mPortNumber = portNumber;
				return this;
			}
			
			/**Sets up the builder object data base name to connect
			 * @param dbName {@link String} new database name to connect
			 * @return {@link DBConnectionParams} builder object*/
			public DBConnectionParamsBuilder dbName(String dbName){
				this.mDBName = dbName;
				return this;
			}
			
			/**Sets up the builder object connecting user name
			 * @param userName {@link String} new connecting user name
			 * @return {@link DBConnectionParams} builder object*/
			public DBConnectionParamsBuilder userName(String userName){
				this.mUserName = userName;
				return this;
			}
			
			/**Sets up the builder object connecting user password
			 * @param password {@link String} new connecting user password
			 * @return {@link DBConnectionParams} builder object*/
			public DBConnectionParamsBuilder password(String password){
				this.mPassword = password;
				return this;
			}
			
			public DBConnectionParams buildDBConnectionParams(){
				DBConnectionParams result = new DBConnectionParams();
				result.mHostName = this.mHostName;
				result.mDBName = this.mDBName;
				result.mPortNumber = this.mPortNumber;
				result.mUserName = this.mUserName;
				result.mPassword = this.mPassword;
				
				return result;
			}
		}
	}
}


