package Stock;

public class Stock {
	 String symbol;
	 String name;
	 double previousClosingPrice;
	 double currentPrice;
	
	public Stock() {
		symbol="00000";
		name="java";
	}
	
	public Stock(String symbol,String name,double previousClosingPrice,double currentPrice) {
		this.symbol=symbol;
		this.name=name;
		this.previousClosingPrice=previousClosingPrice;
		this.currentPrice=currentPrice;
	}
	
	public double getChangePercent() {
		return (Math.max(previousClosingPrice, currentPrice) - Math.min(previousClosingPrice, currentPrice))/previousClosingPrice*100;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock s=new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println("Symbol:"+s.symbol);
		System.out.println("Name:"+s.name);
		System.out.println("PreviousClosingPrice:"+s.previousClosingPrice);
		System.out.println("CurrentPrice:"+s.currentPrice);
		System.out.println("ChangePercent:"+s.getChangePercent()+"%");
	}

}
