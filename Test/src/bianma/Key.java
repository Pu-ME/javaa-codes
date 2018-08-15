package bianma;
import java.util.Arrays;
import java.util.Scanner;


public class Key {
	
	//String数组转换为Int数组
	static double[] transform(String[] str) {
		double[] temp = new double[str.length];
		for(int i=0;i<temp.length;i++) {
			temp[i]=Double.parseDouble(str[i]);
		}
		return temp;
	}
	//等长编码
	static void dengchang(double[] fre) {
		String[] str = new String[fre.length];
		for(int i=0;i<fre.length;i++) {
			str[i]=Integer.toBinaryString(i);
		}
		System.out.println("指令频度\t等长编码\t");
		for(int i=0;i<str.length;i++) {
			System.out.print(fre[i]+"\t");
			if(str[i].length() < str[str.length-1].length()) {
				int t = str[str.length-1].length() - str[i].length();
				while(t>0) {
					System.out.print(0);
					t--;
				}
				System.out.println(str[i]);
			}
			else
				System.out.println(str[i]);
		}
	}
	//扩展编码
	static void kuozhan(double[] fre,int n) {
		// TODO Auto-generated method stub
		Arrays.sort(fre);

		 int temp=fre.length,count=0,num=n;
//		 while(temp!=0) {
//			 temp=temp/2;
//			 count++;
//		 }
//		 if((fre.length & (fre.length-1) )== 0) {
//			 count=count-1;
//		 }
		 
		 String[] str=new String[fre.length];
		 for(int i=0;i<num;i++) {
				str[i]=Integer.toBinaryString(i);
			}
		 
		 for(int i=num,j=0;i<str.length;i++,j++) {
			 str[i]=Integer.toBinaryString(j);
		 }
		 
		 int tt=Integer.parseInt(Integer.toBinaryString(num));
		 System.out.println("频度\t扩展编码\t");
		 for(int i=0;i<str.length;i++) {
			 
			 if(i<num) {
				 System.out.print(fre[i]+"\t");
				 if(str[i].length()<str[num-1].length()) {
					 int c= str[num-1].length()-str[i].length();
					 while(c>0) {
					  System.out.print(0);
					  c--;
					 }
				 }
					 System.out.println(str[i]+"\t");
			 }
			 else {
				 	System.out.print(fre[i]+"\t");
				 	System.out.print(tt);
				 	if(str[i].length() < str[str.length-1].length()) {
						int t = str[str.length-1].length() - str[i].length();
						while(t>0) {
							System.out.print(0);
							t--;
						}
						System.out.println(str[i]);
					}
					else
						System.out.println(str[i]);
				}
				 	
				 	
			 }
	  }
	//huffman编码
	 static class Node{
	        double weight;			
	        int parent;			
	        int leftChild;			
	        int rightChild;			

	        public Node(double weight,int parent,int leftChild,int rightChild){
	            this.weight=weight;
	            this.parent=parent;
	            this.leftChild=leftChild;
	            this.rightChild=rightChild;
	        }

	        void setWeight(double weight){
	            this.weight=weight;
	        }

	        void setParent(int parent){
	            this.parent=parent;
	        }

	        void setLeftChild(int leftChild){
	            this.leftChild=leftChild;
	        }

	        void setRightChild(int rightChild){
	            this.rightChild=rightChild;
	        }

	        double getWeight(){
	            return weight;
	        }

	        int getParent(){
	            return parent;
	        }

	        int getLeftChild(){
	            return leftChild;
	        }

	        int getRightChild(){
	            return rightChild;
	        }
	    }

	    //新建哈夫曼编码
	    static class NodeCode{
	        String code;
	        NodeCode(String code){
	            this.code= code;
	        }
	        void setCode(String code){
	            this.code=code;
	        }
	        String getCode(){
	            return code;
	        }
	    }
	    //初始化huffuman树
	    public static void initHuffmanTree(Node[] huffmanTree,int m){
	        for(int i=0;i<m;i++){
	            huffmanTree[i] = new Node(0,-1,-1,-1);
	        }
	    }
	    //初始化huffmanCode
	    public static void initHuffmanCode(NodeCode[] huffmanCode,int n){
	        for(int i=0;i<n;i++){
	            huffmanCode[i]=new NodeCode("");
	        }
	    }
	    //获取huffman树节点频数
	    public static void getHuffmanWeight(Node[] huffmanTree , int n,double[] fre){
	        
	        for(int i=0;i<n;i++){
	            huffmanTree[i] = new Node(fre[i],-1,-1,-1);
	        }
	    }
	    //从n个结点中选取最小的两个结点
	    public static int[] selectMin(Node[] huffmanTree ,int n)  
	    {  
	        int min[] = new int[2];
	          class TempNode
	           {  
	                  double newWeight;//存储权  
	                  int place;//存储该结点所在的位置  

	                  TempNode(double newWeight,int place){
	                      this.newWeight=newWeight;
	                      this.place=place;
	                  }
	                  void setNewWeight(double newWeight){
	                      this.newWeight=newWeight;
	                  }
	                  void setPlace(int place){
	                      this.place=place;
	                  }
	                  double getNewWeight(){
	                      return newWeight;
	                  }
	                  int getPlace(){
	                      return place;
	                  }
	           } 
	           TempNode[] tempTree=new TempNode[n];  
	           //将huffmanTree中没有双亲的结点存储到tempTree中 
	           int i=0,j=0;   
	           for(i=0;i<n;i++)  
	           {  
	                  if(huffmanTree[i].getParent()==-1&& huffmanTree[i].getWeight()!=0)  
	                  {  
	                      tempTree[j]= new TempNode(huffmanTree[i].getWeight(),i);  
	                      j++;  
	                  }  
	           } 

	           int m1=0,m2=0;  
	           for(i=0;i<j;i++)  
	           {  
	                  if(tempTree[i].getNewWeight()<tempTree[m1].getNewWeight())    
	                         m1=i;  
	           } 
	           for(i=0;i<j;i++)  
	           {  
	                  if(m1==m2)  
	                         m2++;                                                        
	                  if(tempTree[i].getNewWeight()<=tempTree[m2].getNewWeight()&& i!=m1)
	                         m2=i;  
	           }  
	           min[0]=tempTree[m1].getPlace();  
	           min[1]=tempTree[m2].getPlace();  
	       return min;
	    }  
	    //创建huffmanTree
	    public static void createHaffmanTree(Node[] huffmanTree,int n){   
	           int m = 2*n-1; 
	           for(int i=n;i<m;i++)  
	           {      
	               int[] min=selectMin(huffmanTree,i);
	               int min1=min[0];
	               int min2=min[1];
	               huffmanTree[min1].setParent(i);  
	               huffmanTree[min2].setParent(i);  
	               huffmanTree[i].setLeftChild(min1);  
	               huffmanTree[i].setRightChild(min2);
	               huffmanTree[i].setWeight(huffmanTree[min1].getWeight()+ huffmanTree[min2].getWeight());   
	           }  
	    } 
	    //创建huffmanCode
	    public static void createHaffmanCode(Node[] huffmanTree,NodeCode[] huffmanCode,int n){
	        char[] code = new char[10]; 
	        int start,c,parent,temp;
	        code[n-1]='0'; 
	        for(int i=0;i<n;i++)  
	           {
	            StringBuffer stringBuffer = new StringBuffer();
	            start=n-1;
	            c=i;
	            System.out.println(huffmanTree[c].getWeight()+" "+huffmanTree[c].getParent()+" "+huffmanTree[c].getLeftChild());
	            System.out.println("---------");
	            while( (parent=huffmanTree[c].getParent()) >=0 ){  
	                         start--;  
	                         if(huffmanTree[parent].getLeftChild()==c) {
	                        	 System.out.print(huffmanTree[parent].getLeftChild()+" "+c+" ");
	                        	 code[start]='0';}
	                         else
	                        	 code[start]='1';
	                         c=parent;  

	                  } 
	            for( ;start<n-1;start++){
	                 stringBuffer.append(code[start]);
	            }
	            huffmanCode[i].setCode(stringBuffer.toString());
	           }
	    }

	    //输出hufmanCode
	    public static void ouputHaffmanCode(Node[] huffmanTree,NodeCode[] huffmanCode,int n){
	        System.out.println("频度\t哈夫曼编码\t");
	        for(int i=n-1;i>=0;i--){
	            System.out.println(huffmanTree[i].getWeight()+"\t"+huffmanCode[i].getCode()+"\t");
	        }
	    }

	static void huffman(double[] fre) {
		// TODO Auto-generated method stub
		int n=fre.length;
		int m=2*n-1;
		Node[] huffmanTree = new Node[m];
	    NodeCode[] huffmanCode = new NodeCode[n];
        initHuffmanTree(huffmanTree,m);
        initHuffmanCode(huffmanCode,n);
        getHuffmanWeight(huffmanTree,n,fre);
        //创建huffmanTree
        createHaffmanTree(huffmanTree,n);
        //创建huffmanCode
        createHaffmanCode(huffmanTree,huffmanCode,n);
        //输出huffmanCode编码
        ouputHaffmanCode(huffmanTree,huffmanCode,n);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String string;
		System.out.print("输入一组频度：");
		string=in.nextLine();
		String []str=string.split(" ");
		double[] freq=new double[str.length];
		System.out.print("输入扩展编码短码的指令条数：");
		int n=in.nextInt();
		freq=transform(str);
		//等长编码
		System.out.println("等长编码：");
		dengchang(freq);
		//扩展编码
		System.out.println("扩展编码：");
		kuozhan(freq,n);
		//哈夫曼编码
		System.out.println("哈夫曼编码：");
		huffman(freq);
	}


}
