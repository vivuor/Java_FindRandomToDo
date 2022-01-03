package model;

public class Tekeminen {

		// attribuutit
		private int id;
		private String nimi;
		private String kuvaus;
		private String sijainti;
		
		// konstruktorit (parametrilliset)
		public Tekeminen(int id, String nimi, String kuvaus, String sijainti) {
			super();
			this.id = id;
			this.nimi = nimi;
			this.kuvaus = kuvaus;
			this.sijainti = sijainti;
		}
		
		// konstruktorit (parametrilliset)
				public Tekeminen(String nimi, String kuvaus, String sijainti) {
					super();
					this.nimi = nimi;
					this.kuvaus = kuvaus;
					this.sijainti = sijainti;
				}

		// konstruktorit (parametriton). Tehdään myös parametriton jotta voidaan hyödyntää tietoa tuleeko annettu arvo vai null, kun sovelluksen
		// toimivuutta testataan.
		public Tekeminen() {
			super();
			this.id = 0;
			this.nimi = null;
			this.kuvaus = null;
			this.sijainti = null;
		}

		// getterit
		public int getId() {
			return id;
		}

		public String getNimi() {
			return nimi;
		}

		public String getKuvaus() {
			return kuvaus;
		}

		public String getSijainti() {
			return sijainti;
		}

		// setterit
		public void setId(int id) {
			this.id = id;
		}

		public void setNimi(String nimi) {
			this.nimi = nimi;
		}

		public void setKuvaus(String kuvaus) {
			this.kuvaus = kuvaus;
		}

		public void setSijainti(String sijainti) {
			this.sijainti = sijainti;
		}

		// toString
		@Override
		public String toString() {
			return "Tekeminen [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus + ", sijainti=" + sijainti + "]";
		}
}
