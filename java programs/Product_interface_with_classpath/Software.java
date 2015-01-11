public class Software extends Product
{
        private String version;

        public Software()
        {
                version = "";
        }
	
	public Software(String code, String description, double price, String version)
	{
		super(code,description,price);
		this.version = version;
	}

        public void setVersion(String version)
        {
                this.version = version;
        }

        public String getVersion()
        {
                return version;
        }

        public String toString()
        {
                String s;
                s = super.toString();
                return (s + "Version:    " + version + "\n");
        }


}

