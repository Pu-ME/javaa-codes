package Tax;

public class Tax {
	private static final int SINGLE_FILER=0;
	private static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW=1;
	private static final int MARRIED_SEPARATELY=2;
	private static final int HEAD_OF_HOUSEHOLD=3;
	int filingStatus;
	private int[][] brackets= {
			{27050,65550,136750,297350},  //SINGLE_FILER
			{45200,109250,166500,297350}, //MARRIED_JOINTLY_OR_QUALIFYING_WIDOW
			{22660,54625,83250,128675},   //MARRIED_SEPARATELY
			{36250,93650,151650,297350}   //HEAD_OF_HOUSEHOLD
	};
	private double []rates= {0.15,0.275,0.305,0.355,0.391};
	double taxableIncome;
	public Tax() {
		
	}
	public Tax(int filingStatus,int[][] brackets,double[] rates,double taxableIncome) {
		this.filingStatus=filingStatus;
		this.brackets=brackets;
		this.rates=rates;
		this.taxableIncome=taxableIncome;
	}
	public void setFilingStatus(int filingStatus) {
		this.filingStatus = filingStatus;
	}
	public int getFilingStatus() {
		return filingStatus;
	}
	public int[][] getBrackets(){
        return brackets;
    }
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome=taxableIncome;
	}
    public void setBrackets(int[][] brackets){
        this.brackets = brackets;
    }
    public double[] getRates(){
        return rates;
    }

    public void setRates(double[] rates){
        this.rates = rates;
    }
    public double getTax() {
    	double tax=0;
    	if(taxableIncome<=brackets[filingStatus][0])
    		return tax=taxableIncome*rates[0];
    	else
    		tax=brackets[filingStatus][0]*rates[0];
    	
    	int i;
    	for(i=1;i<brackets[0].length;i++) {
    		if(taxableIncome>brackets[filingStatus][i])
    			tax+=(brackets[filingStatus][i] - brackets[filingStatus][i - 1]) *
    			          rates[i];
    		else {
    	        tax += (taxableIncome - brackets[filingStatus][i - 1]) * rates[i];
    	        break;
    	      }
    	}

    	if (i == brackets[0].length && taxableIncome > brackets[filingStatus][i - 1])
   		      tax += (taxableIncome - brackets[filingStatus][i - 1]) * rates[i];
    		 return tax;
    }
}
