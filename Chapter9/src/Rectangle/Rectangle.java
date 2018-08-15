 package Rectangle;

public class Rectangle {
	private double width;
	  private double height;
	  
	 public Rectangle(){
		  width=1.0;
		  height=1.0;
	 }
	 
	 public Rectangle(double width,double height) {
		 this.width=width;
		 this.height=height;
	 }
	 public double getWidth() {
		 return width;
	 }
	 public double getHeight() {
		 return height;
	 }

	 public double getArea() {
		 return width*height;
	 }
	 
	 public double getPerimeter() {
		 return 2*(width+height);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle t1=new Rectangle(4,40);
		Rectangle t2=new Rectangle(3.5,35.9);
		
		System.out.println("width:"+t1.getWidth()+" height:"+t1.getHeight()
		+" Area:"+t1.getArea()+" Per:"+t1.getPerimeter());
		System.out.println("width:"+t2.getWidth()+" height:"+t2.getHeight()
		+" Area:"+t2.getArea()+" Per:"+t2.getPerimeter());
	}

}
