package Tax;

public class TestTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] bracketsFor2001 = {
			      {27050, 65550, 136750, 297350}, // Single filer
			      {45200, 109250, 166500, 297350}, // married filing jointly
			      {22600, 54625, 83250, 148675}, // married filing separately
			      {36250, 93650, 151650, 297350} // head of household
			    };

			    double[] ratesFor2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

			    int[][] bracketsFor2009 = {
			      {8350, 33950, 52250, 171550, 372950}, // Single filer
			      {16700, 6790000, 137050, 208850, 372950}, // married filing jointly
			      {8350, 33950, 68525, 104425, 186475}, // married filing separately
			      {11950, 45500, 117450, 190200, 372950} // head of household
			    };

			    double[] ratesFor2009 = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35};

			    Tax taxFor2001 = new Tax(0, bracketsFor2001, ratesFor2001, 50000);
			    System.out.println("2001 Tax Table");
			    System.out.println("taxable\tSingle\tMarried\tMarried\tHead of");
			    System.out.println("Income\tSingle\tJoint\tSeparate\ta House");
			    for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
			      taxFor2001.setTaxableIncome(taxableIncome);
			      taxFor2001.setFilingStatus(0);
			      int taxForStatus0 = (int)taxFor2001.getTax();
			      taxFor2001.setFilingStatus(1);
			      int taxForStatus1 = (int)taxFor2001.getTax();
			      taxFor2001.setFilingStatus(2);
			      int taxForStatus2 = (int)taxFor2001.getTax();
			      taxFor2001.setFilingStatus(3);
			      int taxForStatus3 = (int)taxFor2001.getTax();
			      System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
			        taxForStatus1 + "\t" + taxForStatus2 + "\t" +
			        taxForStatus3);
			    }

			    Tax taxFor2009 = new Tax(0, bracketsFor2009, ratesFor2009, 50000);
			    System.out.println("2002 Tax Table");
			    System.out.println("taxable\tSingle\tMarried\tMarried\tHead of");
			    System.out.println("Income\tSingle\tJoint\tSeparate\ta House");
			    for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
			      taxFor2009.setTaxableIncome(taxableIncome);
			      taxFor2009.setFilingStatus(0);
			      int taxForStatus0 = (int)taxFor2009.getTax();
			      taxFor2009.setFilingStatus(1);
			      int taxForStatus1 = (int)taxFor2009.getTax();
			      taxFor2009.setFilingStatus(2);
			      int taxForStatus2 = (int)taxFor2009.getTax();
			      taxFor2009.setFilingStatus(3);
			      int taxForStatus3 = (int)taxFor2009.getTax();
			      System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
			        taxForStatus1 + "\t" + taxForStatus2 + "\t" +
			        taxForStatus3);
			    }
	}

}
