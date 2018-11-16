package bighomework;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 模拟ALU进行整数和浮点数的四则运算
 * @author 161250032_顾诗玉
 *
 */

public class ALU {
	/**
	 * 生成十进制整数的二进制补码表示。<br/>
	 * 例：integerRepresentation("9", 8)
	 * @param number 十进制整数。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param length 二进制补码表示的长度
	 * @return number的二进制补码表示，长度为length
	 */
	public static void main(String[]args){
		ALU alu=new ALU();
		alu.floatMultiplication("001100000","001110000",4,4);
	}
	public String integerRepresentation (String number, int length) {
		// TODO YOUR CODE HERE.
		int m=Integer.parseInt(number);
		int i=0;
		String s="";
		if(m==0){
        for(int k=0;k<length;k++){
        	s=s+"0";
		}
		}else
        if(m>0){
        	if(m==1){
        	for(int k=0;k<length-1;k++){
        		s=s+"0";
        	}
        	s=s+"1";
        }else if(m>1){
        	char[]s1=new char[length-1];
        	int h=0;
        	s=s+"0";
        	int c=0;
        	for(int k=0;k<length-1;k++){
        		if(m%2==1){
        			m=(m-1)/2;
        			s1[length-k-2]='1';
        			h=h+1;
        		}else if(m%2==0){
        			m=m/2;
        			s1[length-k-2]='0';
        			if(m==1){
            			s1[length-k-3]='1';
            			m=0;
            			h=h+1;
            			c=length-k-3;
            			break;
            		}
        		}
        }
        	if(m==0){
        		for(int p=0;p<c;p++){
        		s1[p]='0';
        		}
        	}
        	s=s+ String.valueOf(s1);
        }
        }
        if(m<0){
        	i=-m;
        	if(i==1){
            	for(int k=0;k<length-1;k++){
            		s=s+"1";
            	}
            	s=s+"1";
            }else if(i>1){
            	s=s+"1";
            	char[]s1=new char[length-1];
            	int h=0;
            	int c=0;
            	for(int k=0;k<length-1;k++){
            		if(i%2==1){
            			i=(i-1)/2;
            			s1[length-k-2]='1';
            			h=h+1;
            		}else{
            		
            			i=i/2;
            			s1[length-k-2]='0';
            			if(i==1){
                			s1[length-k-3]='1';
                			i=0;
                			h=h+1;
                			c=length-k-3;
                			break;
                		}
            		}
            }
            	if(i==0){
            		for(int p=0;p<c;p++){
            			s1[p]='0';
            		}
            	}
            	   for(int d=0;d<length-1;d++){
                   	if(s1[d]=='1'){
                   		s1[d]='0';
                   	}else if(s1[d]=='0'){
                   		s1[d]='1';
                   	}
                   }
                   for(int d1=0;d1<length-1;d1++){
                	   if(s1[length-d1-2]=='1'){
                		   s1[length-d1-2]='0';
                	   }else{
                		   s1[length-d1-2]='1';
                		   break;
                	   }
                   }
            	s=s+String.valueOf(s1);
            }
            }
		return s;
        }
	
	/**
	 * 生成十进制浮点数的二进制表示。
	 * 需要考虑 0、反规格化、正负无穷（“+Inf”和“-Inf”）、 NaN等因素，具体借鉴 IEEE 754。
	 * 舍入策略为向0舍入。<br/>
	 * 例：floatRepresentation("11.375", 8, 11)
	 * @param number 十进制浮点数，包含小数点。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return number的二进制表示，长度为 1+eLength+sLength。从左向右，依次为符号、指数（移码表示）、尾数（首位隐藏）
	 */
	public String floatRepresentation (String number, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		String s="";
		int length=1;
		int length2=2;
		double border3=1;
		int border1=1;
		for(int g=0;g<eLength;g++){
			length=length*2;
		}
		for(int g=0;g<length;g++){
			border1=border1*2;
		}//算出正无穷,正无穷计算会溢出，无法好好使用，所以我选择没有比较因为比较了溢出了使程序无法运行
		for(int t=0;t<eLength;t++){
			length2=length2*2;
		}
		for(int t=0;t<eLength;t++){
			border3=border3/2;//算出规格化与非规格化的界限
		}//非规格化数十分小，也溢出了。。所以没办法。。比较了程序跑不动。。
		if(number.equals("-0")){
			s="1";
			for(int i=0;i<eLength+sLength;i++){
				s=s+"0";
			}
		}else
		if(number.equals("0")){
			s=s+"0";
			for(int i=0;i<eLength+sLength;i++){
				s=s+"0";
			}
		}else
		if(number.equals("-0.0")){
			s="1";
			for(int i=0;i<eLength+sLength;i++){
				s=s+"0";
			}
		}else
		if(number.equals("0.0")){
			s=s+"0";
			for(int i=0;i<eLength+sLength;i++){
				s=s+"0";
			}
		}else
		if(number.equals("+Inf")){
                  s=s+"0";
                  for(int i=0;i<eLength;i++){
                	  s=s+"1";
                  }
                  for(int i=0;i<sLength;i++){
                	  s=s+"0";
                  }
		}else
		if(number.equals("-Inf")){
			s=s+"1";
			for(int i=0;i<eLength;i++){
				s=s+"1";
			}
			for(int i=0;i<sLength;i++){
				s=s+"0";
			}
		}else
		if(number.equals("NaN")){
			s="0";
			for(int i=0;i<eLength;i++){
				s=s+"1";
			}
		}else{
			float h=Float.parseFloat(number);
			if(h<0&&(-border3)<h){
				s=s+"1";
				for(int i=0;i<eLength;i++){
					s=s+"0";
				}
				int e=1;
				for(int i=0;i<eLength-1;i++){
					e=e*2;
				}
				e=e-2;
				h=-h;
				for(int i=0;i<e;i++){
					h=h*2;
				}
				char []cr=new char[sLength];
				h=h*2;
				for(int i=0;i<sLength;i++){
					if(h<1){
						cr[i]='0';
						h=h*2;
					}else if(h==1){
						cr[i]='1';
						h=h-1;
					}else if(h>1){
						cr[i]='1';
						h=h-1;
						h=h*2;
					}
				}
				s=s+String.valueOf(cr);
			}else
			if(0<h&&h<border3){
				//非规格化数
			s=s+"0";
				for(int i=0;i<eLength;i++){
					s=s+"0";
				}
				int e=1;
				for(int i=0;i<eLength-1;i++){
					e=e*2;
				}
				e=e-2;
				for(int i=0;i<e;i++){
					h=h*2;
				}
				char []cr=new char[sLength];
				h=h*2;
				for(int i=0;i<sLength;i++){
					if(h<1){
						cr[i]='0';
						h=h*2;
					}else if(h==1){
						cr[i]='1';
						h=h-1;
					}else if(h>1){
						cr[i]='1';
						h=h-1;
						h=h*2;
					}
				}
				s=s+String.valueOf(cr);
			}else
		    if(border3<h){
			int q=0;
			s=s+"0";
		    int m=(int)h;
		    int m2=(int)h;
			float b;
			b=h-m;//小数部分
			int e=1;
			int count=0;
			int c3=0;
			for(int k=0;k<eLength-1;k++){
			    	e=e*2;//得到阶码偏移量
			}
			e=e-1;
			if(m==0){
				int ecount=0;
				while(b*2<1){
					b=b*2;
				ecount=ecount+1;
				}
				b=h-m;
				m=e-count-1;
				char[]s1=new char[eLength];
	        	char[]s2 = new char[sLength];
	        	char[]s3=new char[sLength];
	        	char[]s4=new char[sLength];
	        	for(int k=0;k<eLength-1;k++){
	        		if(m%2==1){
	        			m=(m-1)/2;
	        			s1[eLength-k-1]='1';
	        		}else{
	        			m=m/2;
	        			s1[eLength-k-1]='0';
	        			if(m==1){
	            			s1[eLength-k-2]='1';
	            			m=0;
	            			for(int p=0;p<eLength-k-2;p++){
	            				s1[p]='0';
	            			}
	            		}
	        			if(m==0){
	        				s1[eLength-k-2]='0';
	        			}
	        		}
	        }   
	        	if(count>0){
	            s1[0]='1';
	        	
	        	}else{
	        		s1[0]='0';
	        	}	
	        	if(m2==1){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2==0){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2>1){
	        		while(m2>0){
	        			if(m2%2==1){
	        				s2[q]='1';
	        				m2=(m2-1)/2;
	        				q=q+1;
	        			}else{
	        				s2[q]='0';
	        				m2=m2/2;
	        				q=q+1;
	        			}
	        		}
	        	}
	        	for(int c1=0;c1<q;c1++){
	        		if(s2[c1]=='0'){
	        			s3[q-c1-1]='0';
	        		}else if(s2[c1]=='1'){
	        			s3[q-c1-1]='1';
	        		}
	        	}
	         for(int c2=0;c2<q;c2++){
	        	 if(s3[c2]=='1'){
	        		 c3=c2;
	        		 break;
	        	 }
	         }
	         c3=c3+1;
	         for(int c4=c3;c4<q;c4++){
	        	 if(s3[c4]=='1'){
	        		 s4[c4-c3]='1';
	        	 }else if(s3[c4]=='0'){
	        		 s4[c4-c3]='0';
	        	 }
	         }
	        	 if(b>0.5){
	        		 s4[q-c3]='1';
	        	 }else{
	        		 s4[q-c3]='0';
	        	 }
	        	 for(int c5=q-c3+1;c5<sLength;
	        			 c5++){
	        		 b=b*2;
	        		 if(b>1){
	        			 s4[c5]='1';
	        			 b=b-1;
	        		 }else if(b<1){
	        			 s4[c5]='0';
	        		 }else if(b==1){
	        			 s4[c5]='0';
	        			 b=b-1;
	        		 }
	        	 }
	         s=s+String.valueOf(s1)+String.valueOf(s4);
	        }
	       else
			if(m==1){
	        	for(int k=0;k<eLength-1;k++){
	        		s=s+"0";
	        	}
	        	s=s+"1";
	        }else if(m>1){
	        	while(m>1){
					if(m%2==1){
						m=(m-1)/2;
						count++;
					}else{
						m=m/2;
						count++;
					}
				}
				m=e+count;
	        	char[]s1=new char[eLength];
	        	char[]s2 = new char[sLength];
	        	char[]s3=new char[sLength];
	        	char[]s4=new char[sLength];
	        	for(int k=0;k<eLength-1;k++){
	        		if(m%2==1){
	        			m=(m-1)/2;
	        			s1[eLength-k-1]='1';
	        		}else{
	        		
	        			m=m/2;
	        			s1[eLength-k-1]='0';
	        			if(m==1){
	            			s1[eLength-k-2]='1';
	            			m=0;
	            			for(int p=0;p<eLength-k-2;p++){
	            				s1[p]='0';
	            			}
	            		}
	        			if(m==0){
	        				s1[eLength-k-2]='0';
	        			}
	        		}
	        	
	        }   
	        	if(count>0){
	            s1[0]='1';
	        	
	        	}else{
	        		s1[0]='0';
	        	}	
	        	if(m2==1){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2==0){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2>1){
	        		while(m2>0){
	        			if(m2%2==1){
	        				s2[q]='1';
	        				m2=(m2-1)/2;
	        				q=q+1;
	        			}else{
	        				s2[q]='0';
	        				m2=m2/2;
	        				q=q+1;
	        			}
	        		}
	        	}
	        	for(int c1=0;c1<q;c1++){
	        		if(s2[c1]=='0'){
	        			s3[q-c1-1]='0';
	        		}else if(s2[c1]=='1'){
	        			s3[q-c1-1]='1';
	        		}
	        	}
	         for(int c2=0;c2<q;c2++){
	        	 if(s3[c2]=='1'){
	        		 c3=c2;
	        		 break;
	        	 }
	         }
	         c3=c3+1;
	         for(int c4=c3;c4<q;c4++){
	        	 if(s3[c4]=='1'){
	        		 s4[c4-c3]='1';
	        	 }else if(s3[c4]=='0'){
	        		 s4[c4-c3]='0';
	        	 }
	         }
	        	 if(b>0.5){
	        		 s4[q-c3]='1';
	        	 }else{
	        		 s4[q-c3]='0';
	        	 }
	        	 b=b*2;
	        	 for(int c5=q-c3+1;c5<sLength;c5++){
	        		 b=b*2;
	        		 if(b>1){
	        			 s4[c5]='1';
	        			 b=b-1;
	        		 }else if(b<1){
	        			 s4[c5]='0';
	        		 }else if(b==1){
	        			 s4[c5]='1';
	        			 b=b-1;
	        		 }
	        	 }
	        	
	         
	         s=s+String.valueOf(s1)+String.valueOf(s4);
	        }
	        
		}else if(0<h&&h<border3){
			s=s+"0";
			char[]s1=new char[eLength];
			for(int i=0;i<eLength;i++){
				s1[i]='0';
			}
			char[]s4=new char[sLength];
			for(int q=0;q<length;q++){
				h=h*2;
			}
			for(int i=0;i<sLength;i++){
			h=h*2;
			if(h>1){
				s4[i]='1';
				h=h-1;
			}else{
				s4[i]='0';
			}
			}
		}
			else if(h<(-border3)){
			s=s+"1";
			h=-h;
			int q=0;
		    int m=(int)h;
		    int m2=(int)h;
			float b;
			b=h-m;//小数部分
			int e=1;
			int count=0;
			int c3=0;
			for(int k=0;k<eLength-1;k++){
			    	e=e*2;//得到阶码偏移量
			}
			e=e-1;
			if(m==0){
				int ecount=0;
				while(b*2<1){
					b=b*2;
				ecount=ecount+1;
				}
				b=h-m;
				m=e-count-1;
				char[]s1=new char[eLength];
	        	char[]s2 = new char[sLength];
	        	char[]s3=new char[sLength];
	        	char[]s4=new char[sLength];
	        	for(int k=0;k<eLength-1;k++){
	        		if(m%2==1){
	        			m=(m-1)/2;
	        			s1[eLength-k-1]='1';
	        		}else{
	        			m=m/2;
	        			s1[eLength-k-1]='0';
	        			if(m==1){
	            			s1[eLength-k-2]='1';
	            			m=0;
	            			for(int p=0;p<eLength-k-2;p++){
	            				s1[p]='0';
	            			}
	            		}
	        			if(m==0){
	        				s1[eLength-k-2]='0';
	        			}
	        		}
	        	
	        }   
	        	if(count>0){
	            s1[0]='1';
	        	
	        	}else{
	        		s1[0]='0';
	        	}	
	        	if(m2==1){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2==0){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2>1){
	        		while(m2>0){
	        			if(m2%2==1){
	        				s2[q]='1';
	        				m2=(m2-1)/2;
	        				q=q+1;
	        			}else{
	        				s2[q]='0';
	        				m2=m2/2;
	        				q=q+1;
	        			}
	        		}
	        	}
	        	for(int c1=0;c1<q;c1++){
	        		if(s2[c1]=='0'){
	        			s3[q-c1-1]='0';
	        		}else if(s2[c1]=='1'){
	        			s3[q-c1-1]='1';
	        		}
	        	}
	         for(int c2=0;c2<q;c2++){
	        	 if(s3[c2]=='1'){
	        		 c3=c2;
	        		 break;
	        	 }
	         }
	         c3=c3+1;
	         for(int c4=c3;c4<q;c4++){
	        	 if(s3[c4]=='1'){
	        		 s4[c4-c3]='1';
	        	 }else if(s3[c4]=='0'){
	        		 s4[c4-c3]='0';
	        	 }
	         }
	        	 if(b>0.5){
	        		 s4[q-c3]='1';
	        	 }else{
	        		 s4[q-c3]='0';
	        	 }
	        	 b=b*2;
	        	 for(int c5=q-c3+1;c5<sLength;
	        			 c5++){
	        		 b=b*2;
	        		 if(b>1){
	        			 s4[c5]='1';
	        			 b=b-1;
	        		 }else if(b<1){
	        			 s4[c5]='0';
	        		 }else if(b==1){
	        			 s4[c5]='1';
	        			 b=b-1;
	        		 }
	        	 }
	         
	         s=s+String.valueOf(s1)+String.valueOf(s4);
	         
	        }else
			if(m==1){
	        	for(int k=0;k<eLength-1;k++){
	        		s=s+"0";
	        	}
	        	s=s+"1";
	        }else if(m>1){
	        	while(m>1){
					if(m%2==1){
						m=(m-1)/2;
						count++;
					}else{
						m=m/2;
						count++;
					}
				}
				m=e+count;
	        	char[]s1=new char[eLength];
	        	char[]s2 = new char[sLength];
	        	char[]s3=new char[sLength];
	        	char[]s4=new char[sLength];
	        	for(int k=0;k<eLength-1;k++){
	        		if(m%2==1){
	        			m=(m-1)/2;
	        			s1[eLength-k-1]='1';
	        		}else{
	        			m=m/2;
	        			s1[eLength-k-1]='0';
	        			if(m==1){
	            			s1[eLength-k-2]='1';
	            			m=0;
	            			for(int p=0;p<eLength-k-2;p++){
	            				s1[p]='0';
	            			}
	            		}
	        			if(m==0){
	        				s1[eLength-k-2]='0';
	        			}
	        		}
	        	
	        }   
	        	if(count>0){
	            s1[0]='1';
	        	
	        	}else{
	        		s1[0]='0';
	        	}	
	        	if(m2==1){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2==0){
	        		s2[0]='0';
	        		q=q+1;
	        	}else if(m2>1){
	        		while(m2>0){
	        			if(m2%2==1){
	        				s2[q]='1';
	        				m2=(m2-1)/2;
	        				q=q+1;
	        			}else{
	        				s2[q]='0';
	        				m2=m2/2;
	        				q=q+1;
	        			}
	        		}
	        	}
	        	for(int c1=0;c1<q;c1++){
	        		if(s2[c1]=='0'){
	        			s3[q-c1-1]='0';
	        		}else if(s2[c1]=='1'){
	        			s3[q-c1-1]='1';
	        		}
	        	}
	         for(int c2=0;c2<q;c2++){
	        	 if(s3[c2]=='1'){
	        		 c3=c2;
	        		 break;
	        	 }
	         }
	         c3=c3+1;
	         for(int c4=c3;c4<q;c4++){
	        	 if(s3[c4]=='1'){
	        		 s4[c4-c3]='1';
	        	 }else if(s3[c4]=='0'){
	        		 s4[c4-c3]='0';
	        	 }
	         }
	        	 if(b>0.5){
	        		 s4[q-c3]='1';
	        	 }else{
	        		 s4[q-c3]='0';
	        	 }
	        	 b=b*2;
	        	 for(int c5=q-c3+1;c5<sLength;c5++){
	        		 b=b*2;
	        		 if(b>1){
	        			 s4[c5]='1';
	        			 b=b-1;
	        		 }else if(b<1){
	        			 s4[c5]='0';
	        			 b=b;
	        		 }else if(b==1){
	        			 s4[c5]='1';
	        			 b=b-1;
	        		 }
	        	 }
	         s=s+String.valueOf(s1)+String.valueOf(s4);
	        }
		}else if(h<0&&(-border3)<h){
			s=s+"1";
			char[]s1=new char[eLength];
			for(int i=0;i<eLength;i++){
				s1[i]='0';
			}
			char[]s4=new char[sLength];
			for(int q=0;q<length;q++){
				h=h*2;
			}
			for(int i=0;i<sLength;i++){
			h=h*2;
			if(h>1){
				s4[i]='1';
				h=h-1;
			}else{
				s4[i]='0';
			}
			}
		}
		}
		return s;
	}
	
	/**
	 * 生成十进制浮点数的IEEE 754表示，要求调用{@link #floatRepresentation(String, int, int) floatRepresentation}实现。<br/>
	 * 例：ieee754("11.375", 32)
	 * @param number 十进制浮点数，包含小数点。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 * @param length 二进制表示的长度，为32或64
	 * @return number的IEEE 754表示，长度为length。从左向右，依次为符号、指数（移码表示）、尾数（首位隐藏）
	 */
	public String ieee754 (String number, int length) {
		// TODO YOUR CODE HERE.
		int eLength=0;
		int sLength=0;
		if(length==32){
			eLength=8;
			sLength=23;
		}else if(length==64){
			eLength=11;
			sLength=52;
		}
		ALU alu=new ALU();
		String s=alu.floatRepresentation(number,eLength,sLength);
		return s;
	}
	
	/**
	 * 计算二进制补码表示的整数的真值。<br/>
	 * 例：integerTrueValue("00001001")
	 * @param operand 二进制补码表示的操作数
	 * @return operand的真值。若为负数；则第一位为“-”；若为正数或 0，则无符号位
	 */
	public String integerTrueValue (String operand) {
		// TODO YOUR CODE HERE.
		String s="";
		String s1=operand.substring(0, 1);
		String s2=operand.substring(1, operand.length());
		//考虑正无穷和非数
		if(s1.equals("0")){
			int sum=0;
			char[]cr=new char[operand.length()-1];
			cr=s2.toCharArray();
			for(int i=0;i<operand.length()-1;i++){
				
				if(cr[operand.length()-2-i]=='0'){
					
				}else if(cr[operand.length()-2-i]=='1'){
					int d=1;
					for(int h=0;h<i;h++){
						d=d*2;
					}
					sum=sum+d;
				}
			}
		s=""+sum;
		}else if(s1.equals("1")){
			String sm="";
			for(int i=0;i<s2.length();i++){
				sm=sm+"0";
			}
			if(s2.equals(sm)){
				int sum=1;
				for(int i=0;i<s2.length();i++){
					sum=sum*2;
				}
				s=s+"-"+sum;
			}else{
			int sum=0;
			s=s+"-";
			char[]cm=new char[operand.length()-1];
			cm=s2.toCharArray();
			for(int i=0;i<operand.length()-1;i++){
				if(cm[i]=='1'){
					cm[i]='0';
				}else if(cm[i]=='0'){
					cm[i]='1';
				}
			}
			for(int i=0;i<operand.length()-1;i++){
				if(cm[operand.length()-2-i]=='1'){
					cm[operand.length()-2-i]='0';
				}else if(cm[operand.length()-2-i]=='0'){
					cm[operand.length()-2-i]='1';
					break;
				}
			}
               for(int i=0;i<operand.length()-1;i++){
				
				if(cm[operand.length()-2-i]=='0'){
					
				}else if(cm[operand.length()-2-i]=='1'){
					int d=1;
					for(int h=0;h<i;h++){
						d=d*2;
					}
					sum=sum+d;
				}
			}
			s=s+""+sum;
			}
		}
		return s;
	}
	
	/**
	 * 计算二进制原码表示的浮点数的真值。<br/>
	 * 例：floatTrueValue("01000001001101100000", 8, 11)
	 * @param operand 二进制表示的操作数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return operand的真值。若为负数；则第一位为“-”；若为正数或 0，则无符号位。正负无穷分别表示为“+Inf”和“-Inf”， NaN表示为“NaN”
	 */
	public String floatTrueValue (String operand, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		String s="";
		int e=1;
		int movement=0;
		String s1=operand.substring(0, 1);
		String s2=operand.substring(1, 1+eLength);
		String s3=operand.substring(eLength+1, operand.length());
		for(int i=0;i<eLength-1;i++){
			e=e*2;
		}
		e=e-1;
		//考虑正无穷和非数
		String wuqiong="";
		for(int i=0;i<eLength;i++){
			wuqiong=wuqiong+"1";
		}
		String s10=operand.substring(1,eLength+1);
		String s11=operand.substring(eLength+1,operand.length());
		String nk="";
		for(int i=0;i<sLength;i++){
			nk=nk+"0";
		}
		if(s10.equals(wuqiong)){
			if(s11.equals(nk)){
			if(s1.equals("0")){
				s="+Inf";
			}else if(s1.equals("1")){
				s="-Inf";
			}
			}else{
				s="NaN";
			}
		}
		else
		if(s1.equals("0")){
			int sum=0;
			char[]ch=new char[eLength-1];
			ch=s2.toCharArray();
			for(int i=0;i<eLength;i++){
              if(ch[eLength-1-i]=='0'){
					
				}else if(ch[eLength-1-i]=='1'){
					int d=1;
					for(int h=0;h<i;h++){
						d=d*2;
					}
					sum=sum+d;
				}
			}
			movement=sum-e;
			if(movement>0){
		    String s4="1"+"."+s3;
		    char temp = 0;
		    char[]cr=new char[s4.length()];
		    cr=s4.toCharArray();
		    int h=0;
		    int seu=0;
		    for(int i=1;i<movement+1;i++){
		    	temp=cr[i];
		    	cr[i]=cr[i+1];
		    	cr[i+1]=temp;
		    }
		    for(int m=0;m<cr.length;m++){
		    	if(cr[m]=='.'){
		    		h=m;
		    		break;
		    	}
		    }
		    	for(int i=0;i<h+1;i++){
		    	    if(cr[h-i]=='0'){
		    	    	
		    	    }else if(cr[h-i]=='1'){
		    	    	int d=1;
		    	    	for(int g=0;g<i-1;g++){
		    	    	d=d*2;
		    	    	
		    	    	}
		    	    	seu=seu+d;
		    	    }
				}
		    float f=0;
		    for(int m=h+1;m<cr.length;m++){
		    	if(cr[m]=='1'){
		    		float d=1;
		    		for(int g=1;g<m-h+1;g++){
						d=(float)(d/(float)2);
		    	}
		    		f=f+d;
		    }
			}
		    float f3=seu+f;
		    s=""+f3;
		}
		else{//解码小于0，左移
			if(s3.equals(nk)&&s2.equals(nk)){
				s="0.0";
			}else{
				if(s3.equals(nk)){
					char[]csd=new char[s2.length()];
					csd=s2.toCharArray();
					int mkl=1;
					int result=0;
					if(csd[csd.length-1]=='1'){
						result=1;
					}
					for(int i=1;i<s2.length();i++){
						if(csd[csd.length-1-i]=='1'){
							mkl=mkl*2;
							result=result+mkl;
						}
					}
					int mo=result-e;
					double resul5t=1.0;
					for(int i=0;i<mo;i++){
						resul5t=resul5t/2;
					}
					s=s+resul5t;
				}else{
			String s4="1"+s3;
		    movement=-movement;
		    for(int i=0;i<movement-1;i++){
		    	s4="0"+s4;
		    }
		    s4="0"+"."+s4;
		    char[]cr=new char[s4.length()];
		    cr=s4.toCharArray();
		    float f=0;
		    for(int i=2;i<s4.length();i++){
		    	if(cr[i]=='1'){
		    		float d=1;
		    		for(int g=1;g<i;g++){
		    		d=(float)(d/(float)2);
		    		}
		    	    f=f+d;
		    	}
		    }
		    s=""+f;
			}
			}
		}
		}
		else if(s1.equals("1")){
			s=s+"-";
			int sum=0;
			char[]ch=new char[eLength-1];
			ch=s2.toCharArray();
			for(int i=0;i<eLength;i++){
              if(ch[eLength-1-i]=='0'){
					
				}else if(ch[eLength-1-i]=='1'){
					int d=1;
					for(int h=0;h<i;h++){
						d=d*2;
					}
					sum=sum+d;
					
				}
			}
			movement=sum-e;
			if(movement>1){
		    String s4="1"+"."+s3;
		    char temp = 0;
		    char[]cr=new char[s4.length()];
		    cr=s4.toCharArray();
		    int h=0;
		    int seu=0;
		    for(int i=1;i<movement+1;i++){
		    	temp=cr[i];
		    	cr[i]=cr[i+1];
		    	cr[i+1]=temp;
		    }
		    for(int m=0;m<cr.length;m++){
		    	if(cr[m]=='.'){
		    		h=m;
		    		break;
		    	}
		    }
		    	for(int i=0;i<h+1;i++){
		    	    if(cr[h-i]=='0'){
		    	    	
		    	    }else if(cr[h-i]=='1'){
		    	    	int d=1;
		    	    	for(int g=0;g<i-1;g++){
		    	    	d=d*2;
		    	    	
		    	    	}
		    	    	seu=seu+d;
		    	    }
				}
		    float f=0;
		    for(int m=h+1;m<cr.length;m++){
		    	if(cr[m]=='1'){
		    		float d=1;
		    		for(int g=1;g<m-h+1;g++){
						d=(float)(d/(float)2);
		    	}
		    		f=f+d;
		    }
			}
		    float f3=seu+f;
		    s=s+""+f3;
		}else{
			//阶码为0的情况
			String sd="";
			for(int i=0;i<eLength;i++){
				sd=sd+"0";
			}
			if(s2.equals(sd)){
				char[]cl=new char[s3.length()];
				cl=s3.toCharArray();
				double result=0;
				for(int i=0;i<cl.length;i++){
					double count=1;
					if(cl[i]=='1'){
						for(int j=0;j<i+1;j++){
							count=count/2;
						}
						result=result+count;
					}
				}
				for(int i=0;i<(e-1);i++){
					result=result/2;
				}
				s=s+result;
			}else{
			String s4="1"+s3;
		    movement=-movement;
		    for(int i=0;i<movement-1;i++){
		    	s4="0"+s4;
		    }
		    s4="0"+"."+s4;
		    char[]cr=new char[s4.length()];
		    cr=s4.toCharArray();
		    double f=0;
		    for(int i=2;i<s4.length();i++){
		    	if(cr[i]=='1'){
		    		double d=1;
		    		for(int g=1;g<i;g++){
		    		d=(double)(d/(double)2);
		    		}
		    	    f=f+d;
		    	}
		    }
		    s=s+""+f;
		}
		}
		}
		return s;
	}
	
	/**
	 * 按位取反操作。<br/>
	 * 例：negation("00001001")
	 * @param operand 二进制表示的操作数
	 * @return operand按位取反的结果
	 */
	public String negation (String operand) {
		char[]cr=new char[operand.length()];
		cr=operand.toCharArray();
		for(int i=0;i<operand.length();i++){
			if(cr[i]=='0'){
				cr[i]='1';
			}else if(cr[i]=='1'){
				cr[i]='0';
			}
		}
		
		String s=String.valueOf(cr);
	    return s;
	    
	}
	
	/**
	 * 左移操作。<br/>
	 * 例：leftShift("00001001", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 左移的位数
	 * @return operand左移n位的结果
	 */
	public String leftShift (String operand, int n) {
		// TODO YOUR CODE HERE.
		if(operand.length()>n){
		char[]cr=new char[operand.length()];
		cr=operand.toCharArray();
		for(int i=0;i<cr.length-n;i++){
			cr[i]=cr[i+n];
		}
		for(int g=cr.length-n;g<cr.length;g++){
			cr[g]='0';
		}
		  String s=String.valueOf(cr);
		  return s;
		}else{
			String k="";
			for(int i=0;i<operand.length();i++){
		     k=k+"0";		
			}
			return k;
		}
		
	}
	
	/**
	 * 逻辑右移操作。<br/>
	 * 例：logRightShift("11110110", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 右移的位数
	 * @return operand逻辑右移n位的结果
	 */
	public String logRightShift (String operand, int n) {
		// TODO YOUR CODE HERE.
		if(operand.length()>n){
		char[]cr=new char[operand.length()];
		cr=operand.toCharArray();
		for(int i=0;i<cr.length-n;i++){
			cr[cr.length-1-i]=cr[cr.length-n-1-i];
		}
		for(int g=0;g<n;g++){
		  cr[g]='0';
		}
	     String s=String.valueOf(cr);
	     return s;
		}else{
		String k="";
		for(int i=0;i<operand.length();i++){
			k=k+"0";
		}
		return k;
		}
	}
	
	/**
	 * 算术右移操作。<br/>
	 * 例：logRightShift("11110110", 2)
	 * @param operand 二进制表示的操作数
	 * @param n 右移的位数
	 * @return operand算术右移n位的结果
	 */
	public String ariRightShift (String operand, int n) {
		// TODO YOUR CODE HERE.
		if(operand.length()>=n){
		String s1=operand.substring(0, 1);
		char[]cr=new char[operand.length()];
		cr=operand.toCharArray();
		if(s1.equals("0")){
			for(int i=0;i<cr.length-n;i++){
				cr[cr.length-1-i]=cr[cr.length-n-1-i];
			}
			for(int g=0;g<n;g++){
				cr[g]='0';
			}
		}else{
			for(int i=0;i<cr.length-n;i++){
				cr[cr.length-1-i]=cr[cr.length-n-1-i];
			}
			for(int g=0;g<n;g++){
				cr[g]='1';
		}
		}
		String s=String.valueOf(cr);
		return s;
		}else{
			String k="";
			String s1=operand.substring(0,1);
			for(int i=0;i<operand.length();i++){
				k=k+s1;
				}
			return k;
		}
		
	}
	
	/**
	 * 全加器，对两位以及进位进行加法运算。<br/>
	 * 例：fullAdder('1', '1', '0')
	 * @param x 被加数的某一位，取0或1
	 * @param y 加数的某一位，取0或1
	 * @param c 低位对当前位的进位，取0或1
	 * @return 相加的结果，用长度为2的字符串表示，第1位表示进位，第2位表示和
	 */
	public String fullAdder (char x, char y, char c) {
		// TODO YOUR CODE HERE.
		char first=0;
		char second=0;
		if(x=='1'&&y=='1'){
			first='1';
			second='0';
			if(c=='1'){
			   second='1';
			}else{
				
			}
		}else if(x=='0'&&y=='0'){
			first='0';
			second='0';
			if(c=='1'){
				second='1';
			}else{
				
			}
		}else{
			first='0';
			second='1';
			if(c=='1'){
				first='1';
				second='0';
			}
		}
		String s=String.valueOf(first)+String.valueOf(second);
		return s;
	}
	
	/**
	 * 4位先行进位加法器。要求采用{@link #fullAdder(char, char, char) fullAdder}来实现<br/>
	 * 例：claAdder("1001", "0001", '1')
	 * @param operand1 4位二进制表示的被加数
	 * @param operand2 4位二进制表示的加数
	 * @param c 低位对当前位的进位，取0或1
	 * @return 长度为5的字符串表示的计算结果，其中第1位是最高位进位，后4位是相加结果，其中进位不可以由循环获得
	 */
	public String claAdder (String operand1, String operand2, char c) {
		// TODO YOUR CODE HERE.
		char[]x=operand1.toCharArray();
		char[]y=operand2.toCharArray();
		char[]sum=new char[operand1.length()];
		char[]into=new char[operand1.length()];
		if(x[x.length-1]=='1'&&y[y.length-1]=='1'){
        	if(c=='1'){
        		sum[x.length-1]='1';
        		into[x.length-1]='1';
        	}else if(c=='0'){
        		into[x.length-1]='1';
        		sum[x.length-1]='0';
        	}
		}else if(x[x.length-1]=='0'&&y[y.length-1]=='0'){
			sum[x.length-1]='0';
        	into[x.length-1]='0';
        	if(c=='1'){
        		sum[x.length-1]='1';
        	}else{
        		sum[x.length-1]='0';
        	}
		}else if(x[x.length-1]=='1'&&y[y.length-1]=='0'){
			sum[x.length-1]='1';
			into[x.length-1]='0';
			if(c=='1'){
        		sum[x.length-1]='0';
        		into[x.length-1]='1';
        	}else if(c=='0'){
        		sum[x.length-1]='1';
        		into[x.length-1]='0';
		}
		}else if(x[x.length-1]=='0'&&y[y.length-1]=='1'){
			sum[x.length-1]='1';
			into[x.length-1]='0';
			if(c=='1'){
        		sum[x.length-1]='0';
        		into[x.length-1]='1';
        	}else if(c=='0'){
        		sum[x.length-1]='1';
        		into[x.length-1]='0';
		}
		}
		for(int i=1;i<x.length;i++){
	        if(x[x.length-1-i]=='1'&&y[y.length-1-i]=='1'&&into[x.length-i]=='1'){
	        	sum[x.length-1-i]='1';
	        	into[x.length-1-i]='1';
	        }else if(x[x.length-1-i]=='1'&&y[y.length-1-i]=='1'&&into[x.length-i]=='0'){
	        	sum[x.length-1-i]='0';
	        	into[x.length-1-i]='1';
	        }else if(x[x.length-1-i]=='0'&&y[y.length-1-i]=='0'&&into[x.length-i]=='1'){
	        	sum[x.length-1-i]='1';
	        	into[x.length-1-i]='0';
	        }else if(x[x.length-1-i]=='0'&&y[y.length-1-i]=='0'&&into[x.length-i]=='0'){
	        	sum[x.length-1-i]='0';
	        	into[x.length-1-i]='0';
		}else if(x[x.length-1-i]=='1'&&y[y.length-1-i]=='0'&&into[x.length-i]=='1'){
        	sum[x.length-1-i]='0';
        	into[x.length-1-i]='1';
		}else if(x[x.length-1-i]=='0'&&y[y.length-1-i]=='1'&&into[x.length-i]=='1'){
        	sum[x.length-1-i]='0';
        	into[x.length-1-i]='1';
		}else if(x[x.length-1-i]=='1'&&y[y.length-1-i]=='0'&&into[x.length-i]=='0'){
        	sum[x.length-1-i]='1';
        	into[x.length-1-i]='0';
		}else if(x[x.length-1-i]=='0'&&y[y.length-1-i]=='1'&&into[x.length-i]=='0'){
        	sum[x.length-1-i]='1';
        	into[x.length-1-i]='0';
		}
		}
		 String s=String.valueOf(into[0])+String.valueOf(sum);
		return s;
	}
	
	/**
	 * 加一器，实现操作数加1的运算。
	 * 需要采用与门、或门、异或门等模拟，
	 * 不可以直接调用{@link #fullAdder(char, char, char) fullAdder}、
	 * {@link #claAdder(String, String, char) claAdder}、
	 * {@link #adder(String, String, char, int) adder}、
	 * {@link #integerAddition(String, String, int) integerAddition}方法。<br/>
	 * 例：oneAdder("00001001")
	 * @param operand 二进制补码表示的操作数
	 * @return operand加1的结果，长度为operand的长度加1，其中第1位指示是否溢出（溢出为1，否则为0），其余位为相加结果
	 */
	public String oneAdder (String operand) {
		// TODO YOUR CODE HERE.
		String s1="0";
		char[]cr=new char[operand.length()];
		cr=operand.toCharArray();
		char[]into=new char[operand.length()];
		if(cr[operand.length()-1]=='1'){
			cr[operand.length()-1]='0';
			into[operand.length()-1]='1';
		}else{
			cr[operand.length()-1]='1';
			into[operand.length()-1]='0';
		}
		for(int i=operand.length()-2;i>0;i--){
			if(cr[i]=='1'&&into[i+1]=='1'){
				cr[i]='0';
				into[i]='1';
			}else if(cr[i]=='0'&&into[i+1]=='1'){
				cr[i]='1';
				into[i]='0';
			}else if(into[i+1]=='0'){
				cr[i]=cr[i];
				into[i]='0';
			}
		}
		if(cr[0]=='0'&&into[1]=='1'){
			cr[0]='1';
			s1="0";
		}else if(cr[0]=='1'&&into[1]=='1'){
			cr[0]='0';
			s1="1";
		}else{
			s1="0";
		}//s1为进位
		ALU alu=new ALU();
		String s2=alu.integerTrueValue(operand);
		int m2=Integer.parseInt(s2);
		if(m2==-1){
			s1="0";
		}else{
			String s5=String.valueOf(cr[0]);
			if(s5.equals(operand.substring(0,1))){
				
			}else{
				s1="1";
			}
		}
		String s=s1+String.valueOf(cr);
		return s;
	}
	
	/**
	 * 加法器，要求调用{@link #claAdder(String, String, char)}方法实现。<br/>
	 * 例：adder("0100", "0011", ‘0’, 8)
	 * @param operand1 二进制补码表示的被加数
	 * @param operand2 二进制补码表示的加数
	 * @param c 最低位进位
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相加结果
	 */
	public String adder (String operand1, String operand2, char c, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String s4="";//得到符号位
		//将2个数都扩充为长度为length的数
		int lengthO1=operand1.length();
		int lengthO2=operand2.length();
		String s5=operand1.substring(0,1);
		String s6=operand2.substring(0,1);
		if(lengthO1<length){
		for(int i=length-lengthO1;i>1;i--){
			operand1=s5+operand1;
		}
		}
		if(lengthO2<length){
			for(int i=length-lengthO2;i>0;i--){
				operand2=s6+operand2;
			}
		}
		String s7=alu.integerTrueValue(operand1);
		String s8=alu.integerTrueValue(operand2);
		int m1=Integer.parseInt(s7);
		int m2=Integer.parseInt(s8);
		if(s5.equals("1")&&s6.equals("1")){
			s4="1";
		}else if(s5.equals("1")&&s6.equals("0")){
			m1=-m1;
			if(m1>m2){
				s4="1";
			}else {
				s4="0";
			}
		}else if(s5.equals("0")&&s6.equals("0")){
			s4="0";
		}else if(s5.equals("0")&&s6.equals("1")){
			m2=-m2;
			if(m1>m2){
				s4="0";
			}else{
				s4="1";
			}
		}
		String sm="";
		for(int i=0;i<length;i++){
			sm=sm+"1";
		}
		String sh=alu.claAdder(operand1,operand2,c);
		if(sh.equals(sm)&&c=='1'){
			sm="1";
		}else{
			sm="0";
		}
		String smk=sh.substring(1,2);
		if(s5.equals(smk)||s6.equals(smk)){
			
		}else{
			sm="1";
		}
		String s=alu.claAdder(operand1,operand2,c);
		String s2=s.substring(1, s.length());
		String s3="";
		if(sm.equals("0")){
		for(int i=0;i<length-s.length();i++){
			s3=s3+s4;
		}
		s=sm+s4+s3+s2;
		}else{
			s=sm+s2;
		}
		if(s.length()==(length+2)){
			s=s.substring(0,1)+s.substring(2,2+length);
		}else if(s.length()==(length+3)){
			s=s.substring(0,1)+s.substring(3,s.length());
		}
		return s;
	}
	
	/**
	 * 整数加法，要求调用{@link #adder(String, String, char, int) adder}方法实现。<br/>
	 * 例：integerAddition("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被加数
	 * @param operand2 二进制补码表示的加数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相加结果
	 */
	public String integerAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		char c='0';
		String sm="";//保存溢出位
		String sh="";
		String sg="";
	    sh=alu.integerTrueValue(operand1);
	    sg=alu.integerTrueValue(operand2);
	    int m1=Integer.parseInt(sh);
	    int m2=Integer.parseInt(sg);
		int m3=1;
		for(int i=0;i<length-1;i++){
			m3=m3*2;
		}
		m3=m3-1;
		if((m1+m2)>m3){
			sm="1";
		}else if((m1+m2)<(-m3-1)){
			sm="1";
		}else{
			sm="0";
		}
		String s=alu.adder(operand1, operand2, c,length);
		s=s.substring(1, s.length());
		s=sm+s;
        return s;
	}
	
	/**
	 * 整数减法，可调用{@link #adder(String, String, char, int) adder}方法实现。<br/>
	 * 例：integerSubtraction("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被减数
	 * @param operand2 二进制补码表示的减数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相减结果
	 */
	public String integerSubtraction (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String sm="";//保存溢出位
		String sh="";
		String sg="";
	    char[]cr=new char[operand2.length()];
	    sh=alu.integerTrueValue(operand1);
	    sg=alu.integerTrueValue(operand2);
	    int m1=Integer.parseInt(sh);
	    int m2=Integer.parseInt(sg);
		int m3=1;
		for(int i=0;i<length-1;i++){
			m3=m3*2;
		}
		if((m1-m2)>m3){
			sm="1";
		}else if((m1-m2)<(-m3)){
			sm="1";
		}else{
			sm="0";
		}
	    cr=operand2.toCharArray();
	    for(int i=0;i<cr.length;i++){
	    	if(cr[i]=='0'){
	    		cr[i]='1';
	    	}else if(cr[i]=='1'){
	    		cr[i]='0';
	    	}
	    }
	    for(int i=0;i<cr.length-1;i++){
	    	if(cr[cr.length-i-1]=='1'){
	    		cr[cr.length-i-1]='0';
	    	}else if(cr[cr.length-1-i]=='0'){
	    		cr[cr.length-1-i]='1';
	    		break;
	    	}
	    }
	    char c='0';
	    String s1=String.valueOf(cr);
	    char[]csk=new char[s1.length()];
	    csk=s1.toCharArray();
	    int count=1;
	    for(int i=1;i<s1.length();i++){
	    	if(csk[i]=='0'){
	    		count++;
	    	}
	    }
	    if(count==s1.length()){
	    	s1="0";
	    }
	    String s=alu.adder(operand1, s1, c, length);
	    String s2=s.substring(1, 2);
	    String s3=s.substring(2, s.length());
	    s=sm+s2+s3;
		return s;
	}
	/**
	 * 整数乘法，使用Booth算法实现，可调用{@link #adder(String, String, char, int) adder}等方法。<br/>
	 * 例：integerMultiplication("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被乘数
	 * @param operand2 二进制补码表示的乘数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为length+1的字符串表示的相乘结果，其中第1位指示是否溢出（溢出为1，否则为0），后length位是相乘结果
	 */
	public String integerMultiplication (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		String skl=operand1.substring(0,1);
		String sml=operand2.substring(0,1);
		String s1="";//保存溢出位
		String s2="";
		String s3="";
		ALU alu=new ALU();
		s2=alu.integerTrueValue(operand1);
		s3=alu.integerTrueValue(operand2);
		int m1=Integer.parseInt(s2);
		int m2=Integer.parseInt(s3);
		int m3=1;
		for(int i=0;i<length-1;i++){
			m3=m3*2;
		}
		m3=m3-1;
		if(m1<0){
			m1=-m1;
		}
		if(m2<0){
			m2=-m2;
		}
		if((m1*m2)>m3){
			s1="1";
		}else {
			s1="0";
		}
		char y='0';
		char[]x=new char[operand1.length()];
		char[]z=new char[operand2.length()];
		char[]p=new char[operand2.length()];
		char c='0';
		for(int i=0;i<operand2.length();i++){
			p[i]='0';
		}
		String operand3=String.valueOf(p);
		x=operand1.toCharArray();//把operand1看做被乘数
		z=operand2.toCharArray();//把operand2看做乘数
		//求出-operand1的补码
		for(int i=0;i<x.length;i++){
	    	if(x[i]=='0'){
	    		x[i]='1';
	    	}else if(x[i]=='1'){
	    		x[i]='0';
	    	}
	    }
	    for(int i=0;i<x.length;i++){
	    	if(x[x.length-i-1]=='1'){
	    		x[x.length-i-1]='0';
	    	}else if(x[x.length-1-i]=='0'){
	    		x[x.length-1-i]='1';
	    		break;
	    	}
	    }
	    String operand4=String.valueOf(x);//得到-x补的字符串
		for(int i=0;i<operand1.length();i++){
			if(z[operand2.length()-1]=='0'&&y=='0'){
				y=z[operand2.length()-1];
				operand2=alu.ariRightShift(operand2,1);
				p=operand3.toCharArray();
				operand3=alu.ariRightShift(operand3, 1);
				z=operand2.toCharArray();
				if(p[p.length-1]=='1'){
					z[0]='1';
				}else{
					z[0]='0';
				}
				operand2=String.valueOf(z);
			}else if(z[operand2.length()-1]=='1'&&y=='0'){
				y=z[operand2.length()-1];
				operand3=alu.adder(operand4, operand3, c,length);
				operand3=operand3.substring(2, operand3.length());
				p=operand3.toCharArray();
				operand2=alu.ariRightShift(operand2, 1);
				operand3=alu.ariRightShift(operand3, 1);
				z=operand2.toCharArray();
				if(p[p.length-1]=='1'){
					z[0]='1';
				}else{
					z[0]='0';
				}
				operand2=String.valueOf(z);
			}else if(z[operand2.length()-1]=='1'&&y=='1'){
				y=z[operand2.length()-1];
				p=operand3.toCharArray();
				operand2=alu.ariRightShift(operand2,1);
				operand3=alu.ariRightShift(operand3, 1);
				z=operand2.toCharArray();
				if(p[p.length-1]=='1'){
					z[0]='1';
				}else{
					z[0]='0';
				}
				operand2=String.valueOf(z);
			}else if(z[operand2.length()-1]=='0'&&y=='1'){
				y=z[operand2.length()-1];
				operand3=alu.adder(operand1, operand3, c,length);
				p=operand3.toCharArray();
				operand3=operand3.substring(2, operand3.length());
				operand2=alu.ariRightShift(operand2, 1);
				operand3=alu.ariRightShift(operand3, 1);
				z=operand2.toCharArray();
				if(p[p.length-1]=='1'){
					z[0]='1';
				}else{
					z[0]='0';
				}
				operand2=String.valueOf(z);
			}
			operand2=String.valueOf(z);
		}
		String jij=operand3+operand2;
		int length1=jij.length();
		if(length1<length){
			for(int i=length-length1;i>0;i--){
				jij=jij.substring(0,1)+jij;
			}
			String s=s1+jij;
			return s;
		}else if(length1>length){
			jij=jij.substring(jij.length()-length,jij.length());
			String s=s1+jij;
            //进行溢出处理
			if(s1.equals("1")){
	          if(skl.equals(sml)){
	        	  char[]chr=new char[s.length()];
	        	  chr=s.toCharArray();
	        	  chr[1]='1';
	        	  s=String.valueOf(chr);
	          }else{
	        	  char[]chr=new char[s.length()];
	        	  chr=s.toCharArray();
	        	  chr[1]='0';
	        	  s=String.valueOf(chr);
	          }
			}
			return s;
		}else{
			String s=s1+jij;
			return s;
		}
	}
	
	/**
	 * 整数的不恢复余数除法，可调用{@link #adder(String, String, char, int) adder}等方法实现。<br/>
	 * 例：integerDivision("0100", "0011", 8)
	 * @param operand1 二进制补码表示的被除数
	 * @param operand2 二进制补码表示的除数
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度，当某个操作数的长度小于length时，需要在高位补符号位
	 * @return 长度为2*length+1的字符串表示的相除结果，其中第1位指示是否溢出（溢出为1，否则为0），其后length位为商，最后length位为余数
	 */
	public String integerDivision (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String m1=alu.integerTrueValue(operand1);//operand1是被除数
		String m2=alu.integerTrueValue(operand2);//operand2是除数
		int h1=Integer.parseInt(m1);//h1是被除数
		int h2=Integer.parseInt(m2);//h2是除数
		String s="";
		char[]cr=new char[operand2.length()];
		String s1="";//得到除数的补码
		int r1=length-operand1.length();
		int r2=length-operand2.length();
		if(operand1.length()<length){
			String sm=operand1.substring(0, 1);
			for(int i=0;i<r1;i++){
			operand1=sm+operand1;
			}
		}
		if(operand2.length()<length){
			String sh=operand2.substring(0,1);
			for(int i=0;i<r2;i++){
			operand2=sh+operand2;
			}
		}
		if(h2==0&&h1!=0){//被除数不是0，除数是0
			s="error";
		}else if(h1==0&&h2==0){//被除数是0，除数也是0
			s="NaN";
		}else if(h1>h2){//被除数比除数小
			if(h1>0&&h2>0){//被除数大于0，除数大于0的情况
				//进行一般的情况，对除数取反，进行相减操作,此时不会发生溢出
			int h4=operand2.length();
			cr=operand2.toCharArray();
			for(int i=0;i<h4;i++){
				if(cr[i]=='0'){
					cr[i]='1';
				}else{
					cr[i]='0';
				}
			}
			for(int i=0;i<h4;i++){
				if(cr[h4-1-i]=='1'){
					cr[h4-1-i]='0';
				}else{
					cr[h4-1-i]='1';
					break;
				}
			}
			s1=String.valueOf(cr);
			//得到除数的补码，可以做减法运算了
            int count=1;//用count来计算一共能减几次，得到商
            //得到商的最大值
            int division=1;
            for(int i=0;i<length;i++){
            	division=division*2;
            }
            String s4="";
            s4=operand1;
            for(;count<division;count++){
			s4=alu.adder(s4, s1, '0', length);
			s4=s4.substring(1, s4.length());
			String m3=alu.integerTrueValue(s4);//得到相减后的结果
			int h3=Integer.parseInt(m3);//将相减去的结果与除数进行比较
			if(h3<h2){//如果h3比除数小，说明h3是余数
				s=s+s4;//结果加上余数
				break;//跳出循环
			}
            }
            //count是相减的次数，也就是商
            //将count转化为2进制调用第一个方法
            String hm=String.valueOf(count);
            String s5=alu.integerRepresentation(hm, length);//得到8位的商
            s="0"+s5+s;
		}else if(h1>0&&h2<0){//被除数大于0，除数小于0
			//此时商是负数,先得到2个正数的商的结果然后取反
			//此时除数不用取反,此时比较h2的绝对与h1谁打谁小
			h2=-h2;
			if(h1>h2){
			int count=1;//用count来计算一共能减几次，得到商
			int division=1;
			for(int i=0;i<length;i++){
            	division=division*2;
            }
			String s4="";
			s4=operand1;
			for(;count<division;count++){
					s4=alu.adder(s4, operand2, '0', length);
					s4=s4.substring(1, s4.length());
					String m3=alu.integerTrueValue(s4);//得到相减后的结果
					int h3=Integer.parseInt(m3);//将相减去的结果与除数进行比较
					if(h3<h2){//如果h3比除数小，说明h3是余数
						s=s+s4;//结果加上余数
						break;
					}
			}
			//count是相减的次数，也就是商
	            //将count转化为2进制调用第一个方法
	            String hm=String.valueOf(count);
	            String s5=alu.integerRepresentation(hm, length);//得到8位的商
	            //对商取反
	            char[]kl=new char[hm.length()];
	            kl=s5.toCharArray();
	            for(int i=0;i<kl.length;i++){
	            	if(kl[i]=='1'){
	            		kl[i]='0';
	            	}else{
	            		kl[i]='1';
	            	}
	            }
	            for(int i=0;i<kl.length;i++){
	            	if(kl[kl.length-1-i]=='1'){
	            		kl[kl.length-1-i]='0';
	            	}else{
	            		kl[kl.length-1-i]='1';
	            		break;
	            	}
	            }
	            s5=String.valueOf(kl);
	            s="0"+s5+s;
			}else if(h1<h2){
				//h1比h2的绝对值小
			    //此时商为0
				s="0"+s;
				for(int i=0;i<length;i++){
					s=s+"0";//商全是0
				}
				//operand2直接为余数
				s=s+operand2;
			}
		}
		}else if(h1<h2){
			if(h1>0&&h2>0){
				s="0"+s;
				for(int i=0;i<length;i++){
					s=s+"0";//商全是0
				}
				//operand2直接为余数
				s=s+operand2;
			}else if(h1<0&&h2>0){
				//比较h1的绝对与h2的大小
				h1=-h1;
				if(h1>h2){//h1的绝对值比h2大
					//对h1取反，再对h2也取反，得到商再取反，得到正确的结果。
					char[]cn=new char[s1.length()];
					cn=operand1.toCharArray();//对operand1取反
					for(int i=0;i<operand1.length();i++){
						if(cn[i]=='1'){
							cn[i]='0';
						}else{
							cn[i]='1';
						}
					}
					for(int i=0;i<operand1.length();i++){
						if(cn[operand1.length()-1-i]=='1'){
							cn[operand1.length()-1-i]='0';
						}else{
							cn[operand1.length()-1-i]='1';
							break;
						}
					}
					operand1=String.valueOf(cn);
					//对operand2取反
					char[]ci=new char[operand2.length()];
					ci=operand2.toCharArray();
					for(int i=0;i<operand2.length();i++){
						if(ci[i]=='1'){
							ci[i]='0';
						}else{
							ci[i]='1';
						}
					}
					for(int i=0;i<operand1.length();i++){
						if(ci[operand2.length()-1-i]=='1'){
							ci[operand2.length()-1-i]='0';
						}else{
							ci[operand2.length()-1-i]='1';
							break;
						}
					}
					operand2=String.valueOf(ci);
					//进行正常的相减得到商的操作
					int count=1;
					int division=1;
					for(int i=0;i<length-1;i++){
						division=division*2;
					}
					String s4="";
					s4=operand1;
					for(;count<division;count++){
						s4=alu.adder(s4,operand2,'0',length);
						s4=s4.substring(1, s4.length());
						String m3=alu.integerTrueValue(s4);//得到相减后的结果
						int h3=Integer.parseInt(m3);//将相减去的结果与除数进行比较
						if(h3<h2){//如果h3比除数小，说明h3是余数
							s=s+s4;//结果加上余数
							break;//跳出循环
						}
					}
					//得到商，对商取反
					  //count是相减的次数，也就是商
		            //将count转化为2进制调用第一个方法
		            String hm=String.valueOf(count);
		            String s5=alu.integerRepresentation(hm, length);//得到8位的商
		            //对商取反
		            char[]cu=new char[s5.length()];
		            cu=s5.toCharArray();
		            for(int i=0;i<cu.length;i++){
		            	if(cu[i]=='1'){
		            		cu[i]='0';
		            	}else{
		            		cu[i]='1';
		            	}
		            }
		            for(int i=0;i<cu.length;i++){
		            	if(cu[cu.length-1-i]=='1'){
		            		cu[cu.length-1-i]='0';
		            	}else{
		            		cu[cu.length-1-i]='1';
		            		break;
		            	}
		            }
		            s5=String.valueOf(cu);
		            s="0"+s5+s;
				}else if(h1<h2){//h1的绝对值比h2小，上商为0余数为h2
					s="0"+s;
					for(int i=0;i<length;i++){
						s=s+"0";
					}
					s=s+operand2;
				}
			}else if(h1<0&&h2<0){
				//h1<h2且都小于0，说明h1的绝对值大于h2的绝对值
				//直接转为正数的做法即可
				//此时有唯一的溢出情形发生
				int divisionm=1;
				for(int i=0;i<length-1;i++){
					divisionm=divisionm*2;
				}
				divisionm=-divisionm;
				if(h1==divisionm&&h2==-1){
					s="1"+s;
					for(int i=0;i<2*length;i++){
						s=s+"1";
					}
				}else{
				h1=-h1;
				h2=-h2;
				//此时h1>h2
				//进行一般的情况，对除数取反，进行相减操作,此时不会发生溢出
				int h4=operand2.length();
				cr=operand2.toCharArray();
				for(int i=0;i<h4;i++){
					if(cr[i]=='0'){
						cr[i]='1';
					}else{
						cr[i]='0';
					}
				}
				for(int i=0;i<h4;i++){
					if(cr[h4-1-i]=='1'){
						cr[h4-1-i]='0';
					}else{
						cr[h4-1-i]='1';
						break;
					}
				}
				s1=String.valueOf(cr);
				//得到除数的补码，可以做减法运算了
	            int count=1;//用count来计算一共能减几次，得到商
	            //得到商的最大值
	            int division=1;
	            for(int i=0;i<length;i++){
	            	division=division*2;
	            }
	            String s4="";
	            s4=operand1;
	            for(;count<division;count++){
				s4=alu.adder(s4, s1, '0', length);
				s4=s4.substring(1, s4.length());
				String m3=alu.integerTrueValue(s4);//得到相减后的结果
				int h3=Integer.parseInt(m3);//将相减去的结果与除数进行比较
				if(h3<h2){//如果h3比除数小，说明h3是余数
					s=s+s4;//结果加上余数
					break;//跳出循环
				}
	            }
	            //count是相减的次数，也就是商
	            //将count转化为2进制调用第一个方法
	            String hm=String.valueOf(count);
	            String s5=alu.integerRepresentation(hm, length);//得到8位的商
	            s="0"+s5+s;
				}
			}
		}
		return s;
	}
	
	/**
	 * 带符号整数加法，可以调用{@link #adder(String, String, char, int) adder}等方法，
	 * 但不能直接将操作数转换为补码后使用{@link #integerAddition(String, String, int) integerAddition}、
	 * {@link #integerSubtraction(String, String, int) integerSubtraction}来实现。<br/>
	 * 例：signedAddition("1100", "1011", 8)
	 * @param operand1 二进制原码表示的被加数，其中第1位为符号位
	 * @param operand2 二进制原码表示的加数，其中第1位为符号位
	 * @param length 存放操作数的寄存器的长度，为4的倍数。length不小于操作数的长度（不包含符号），当某个操作数的长度小于length时，需要将其长度扩展到length
	 * @return 长度为length+2的字符串表示的计算结果，其中第1位指示是否溢出（溢出为1，否则为0），第2位为符号位，后length位是相加结果
	 */
	public String signedAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String s="";
		String s7="";//溢出位
		String s8="";//符号位
		String s9="";//结果位
		String s1=operand1.substring(0, 1);
		String s2=operand2.substring(0, 1);
        String s3="";
        String s4="";
		if(s1.equals("1")){
        	s3="0"+operand1.substring(1,operand1.length());
        }else{
        	s3=operand1;
        }
        if(s2.equals("1")){
        	s4="0"+operand2.substring(1,operand2.length());
        }else{
        	s4=operand2;
        }
        String s5="";
        String s6="";
        s5=integerTrueValue(s3);
        s6=integerTrueValue(s4);
        int m1=Integer.parseInt(s5);
        int m2=Integer.parseInt(s6);
        if(s1.equals("1")){
        	m1=-m1;
        }
        if(s2.equals("1")){
        	m2=-m2;
        }
        int m3=1;
        for(int i=0;i<length-1;i++){
        	m3=m3*2;
        }
        m3=m3-1;
        if((m1+m2)<=m3&&(m1+m2)>=(-m3-1)){
        	s7="0";
        }else{
        	s7="1";
        }
        if((m1+m2)>0){
        	s8="0";
        }else if((m1+m2)<0){
        	s8="1";
        }else{
        	if(s1.equals("0")){
        		s8="0";
        	}else{
        		s8="1";
        	}
        }
        if(s1.equals("1")&&s2.equals("1")){
        }else{
        if(s1.equals("1")){
        s3=alu.negation(s3);
        char[]cr=new char[s3.length()];
        cr=s3.toCharArray();
        for(int i=0;i<cr.length;i++){
        	if(cr[cr.length-1-i]=='1'){
        		cr[cr.length-1-i]='0';
        	}else{
        		cr[cr.length-1-i]='1';
        		break;
        	}
        }
        s3=String.valueOf(cr);
        }
        if(s2.equals("1")){
        s4=alu.negation(s4);
        char[]cr=new char[s4.length()];
        cr=s4.toCharArray();
        for(int i=0;i<cr.length;i++){
        	if(cr[cr.length-1-i]=='1'){
        		cr[cr.length-1-i]='0';
        	}else{
        		cr[cr.length-1-i]='1';
        		break;
        	}
        }
        s4=String.valueOf(cr);
        }
        }
        s9=alu.adder(s3, s4, '0',length);
        if(s9.length()==(length+1)){
        	s9=s9.substring(1,s9.length());
            s=s7+s8+s9;
        }else if(s9.length()==(length+2)){
        	s9=s9.substring(2,s9.length());
        	s=s7+s8+s9;
        }
		return s;		
	}
	
	/**
	 * 浮点数加法，可调用{@link #signedAddition(String, String, int) signedAddition}等方法实现。<br/>
	 * 例：floatAddition("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 二进制表示的被加数
	 * @param operand2 二进制表示的加数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @param gLength 保护位的长度
	 * @return 长度为2+eLength+sLength的字符串表示的相加结果，其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatAddition (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		//指数上溢位
		String s10="0";
        String s="";
        //对阶
        ALU alu=new ALU();
        //得到符号位
        String s7="";
        String s8=operand1.substring(0,1);
        String s9=operand2.substring(0,1);
        String s1=operand1.substring(1,eLength+1);
        String s2=operand2.substring(1,eLength+1);
        String s3=alu.integerTrueValue(s1);
        String s4=alu.integerTrueValue(s2);
        int m1=Integer.parseInt(s3);
        int m2=Integer.parseInt(s4);
        int difference=m1-m2;
        //得到阶差
        //得到尾数
        String s5=operand1.substring(operand1.length()-sLength,operand1.length());
        String s6=operand2.substring(operand2.length()-sLength,operand2.length());
        if(s8.equals("0")&&s9.equals("0")){
        	//加法
        	s7="0";
        	if(difference>0){
        		//operand2是小的
        		//对operand2的尾数进行右移
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}else if(difference==0){
        		String result=alu.adder(s5, s6, '0', sLength);
        		char[]cs=new char[s1.length()];
                cs=s1.toCharArray();
        		if(s5.equals(s6)){
        			for(int i=0;i<s1.length();i++){
        				if(cs[cs.length-1-i]=='1'){
        					cs[cs.length-1-i]='0';
        				}else{
        					cs[cs.length-1-i]='1';
        					break;
        				}
        			}
        		}
        		s1=String.valueOf(cs);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}else{
        		s5=alu.logRightShift(s5, (-difference));
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s2+result;
        	}
        }else if(s8.equals("1")&&s9.equals("1")){
        	//加法
        	s7="1";
        	if(difference>0){
        		//operand2是小的
        		//对operand2的尾数进行右移
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}else if(difference==0){
        		String result=alu.adder(s5, s6, '0', sLength);
        		char[]cs=new char[s1.length()];
                cs=s1.toCharArray();
        		if(s5.equals(s6)){
        			for(int i=0;i<s1.length();i++){
        				if(cs[cs.length-1-i]=='1'){
        					cs[cs.length-1-i]='0';
        				}else{
        					cs[cs.length-1-i]='1';
        					break;
        				}
        			}
        		}
        		s1=String.valueOf(cs);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}else{
        		s5=alu.logRightShift(s5, (-difference));
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s2+result;
        	}
        }else if(s8.equals("1")&&s9.equals("0")){
        	//减法
        	s5=alu.negation(s5);
        	char[]cs=new char[s5.length()];
        	cs=s5.toCharArray();
        	for(int i=0;i<cs.length;i++){
        		if(cs[cs.length-1-i]=='1'){
        			cs[cs.length-1-i]='0';
        		}else{
        			cs[cs.length-1-i]='1';
        			break;
        		}
        	}
        	if(difference>0){
        		s7="1";
        		//operand2是小的
        		//对operand2的尾数进行右移
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}else if(difference==0){
        		s7="0";
        		String result=alu.adder(s5, s6, '0', sLength);
        		char[]cs1=new char[s1.length()];
                cs1=s1.toCharArray();
        		if(s5.equals(s6)){
        			for(int i=0;i<s1.length();i++){
        				if(cs1[cs1.length-1-i]=='1'){
        					cs1[cs1.length-1-i]='0';
        				}else{
        					cs1[cs1.length-1-i]='1';
        					break;
        				}
        			}
        		}
        		s1=String.valueOf(cs1);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}else{
        		s7="0";
        		s5=alu.logRightShift(s5, (-difference));
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s2=alu.adder(s2, dlk, '0', eLength);
        			s2=s2.substring(1,s2.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s2=alu.adder(s2, dlk, '0', eLength);
        			s2=s2.substring(1,s2.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s2+result;
        	}
        }else if(s8.equals("0")&&s9.equals("1")){
        	//减法
        	//对s6的尾数取反
        	s6=alu.negation(s6);
        	char[]csdw=new char[s6.length()];
        	csdw=s6.toCharArray();
        	for(int i=0;i<csdw.length;i++){
        		if(csdw[csdw.length-1-i]=='1'){
        			csdw[csdw.length-1-i]='0';
        		}else{
        			csdw[csdw.length-1-i]='1';
        			break;
        		}
        	}
        	s6=String.valueOf(csdw);
          	if(difference>0){
          		s7="0";
        		//operand2是小的
        		//对operand2的尾数进行右移
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}else if(difference==0){
        		s7="0";
        		String result=alu.adder(s5, s6, '0', sLength);
        		char[]cs1=new char[s1.length()];
                cs1=s1.toCharArray();
        		if(s5.equals(s6)){
        			for(int i=0;i<s1.length();i++){
        				if(cs1[cs1.length-1-i]=='1'){
        					cs1[cs1.length-1-i]='0';
        				}else{
        					cs1[cs1.length-1-i]='1';
        					break;
        				}
        			}
        		}
        		s1=String.valueOf(cs1);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        		    char[]csd=new char[s1.length()];
        		    csd=s1.toCharArray();
        		    for(int i=0;i<csd.length;i++){
        		    if(csd[csd.length-1-i]=='1'){
        		    	csd[csd.length-1-i]='0';
        		    	break;
        		    }else{
        		    	csd[csd.length-1-i]='0';
        		    }
        		    }
        		    s1=String.valueOf(csd);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		result=alu.leftShift(result, sLength/2);
        		String ddd="";
        		for(int i=0;i<sLength;i++){
        			ddd=ddd+"0";
        		}
        		if(result.equals(ddd)){
        			for(int i=0;i<(2+eLength+sLength);i++){
        				s=s+"0";
        			}
        		}else{
        		s=s10+s7+s1+result;
        		}
        	}else{
        		s7="1";
        		s5=alu.logRightShift(s5, (-difference));
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//看尾数是否溢出，溢出进行右移
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码减1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//看第一位为1进行右移
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//阶码加1
        			String dlk="";
        			for(int i=0;i<eLength-1;i++){
        				dlk=dlk+"0";
        			}
        			dlk=dlk+"1";
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		result=result.substring(1,result.length());
        		s=s10+s7+s1+result;
        	}
        }
		return s;
	}
	
	/**
	 * 浮点数减法，可调用{@link #floatAddition(String, String, int, int, int) floatAddition}方法实现。<br/>
	 * 例：floatSubtraction("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 二进制表示的被减数
	 * @param operand2 二进制表示的减数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @param gLength 保护位的长度
	 * @return 长度为2+eLength+sLength的字符串表示的相减结果，其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatSubtraction (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		String s="";
		//对减数取反后用floatAddition
		ALU alu=new ALU();
		char[]cs=new char[operand2.length()];
		cs=operand2.toCharArray();
		if(cs[0]=='0'){
		cs[0]='1';
		}else{
			cs[0]='1';
		}
		operand2=String.valueOf(cs);
		s=alu.floatAddition(operand1, operand2, eLength, sLength, gLength);
		return s;
	}
	
	/**
	 * 浮点数乘法，可调用{@link #integerMultiplication(String, String, int) integerMultiplication}等方法实现。<br/>
	 * 例：floatMultiplication("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 二进制表示的被乘数
	 * @param operand2 二进制表示的乘数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return 长度为2+eLength+sLength的字符串表示的相乘结果,其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatMultiplication (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		//先得到符号位
		//浮点数乘法，阶码相加，尾数相乘
		String s="";
				String s4=operand1.substring(1, eLength+1);
				String s5=operand1.substring(operand1.length()-sLength,operand1.length());
				String s6=operand2.substring(1, eLength+1);
				String s7=operand2.substring(operand1.length()-sLength, operand1.length());
		String kk="";
		for(int i=0;i<eLength;i++){
			kk=kk+"0";
		}
		String dd="";
		for(int i=0;i<sLength;i++){
			dd=dd+"0";
		}
		String s1=operand1.substring(0, 1);
		String s2=operand2.substring(0, 1);
		String s3="";
		if(s1.equals("1")&&s2.equals("1")){
			s3="0";
		}else if(s1.equals("1")&&s2.equals("0")){
			if(s4.equals(kk)&&s5.equals(dd)){
				s3="0";
			}else
			if(s6.equals(kk)&&s7.equals(dd)){
				s3="0";
			}else{
			s3="1";
			}
		}else if(s1.equals("0")&&s2.equals("1")){
			if(s4.equals(kk)&&s5.equals(dd)){
				s3="0";
			}else
			if(s6.equals(kk)&&s7.equals(dd)){
				s3="0";
			}else{
			s3="1";
			}
		}else{
			s3="0";
		}
		//将阶码相加
		//operand1的移码
		//operand2的阶码转为补码
		String truth=integerTrueValue(s6);
		//得到偏移量
		int e=1;
		for(int i=0;i<eLength-1;i++){
			e=e*2;
		}
		e=e-1;
        int r=Integer.parseInt(truth);
        int difference=r-e;
        String d=""+difference;
        s6=integerRepresentation(d,eLength);
		String s8=adder(s4,s6,'0',eLength);
		s8=s8.substring(1,s8.length());
		//尾数相乘
		String sddd="";
		for(int i=0;i<eLength;i++){
			sddd=sddd+"0";
		}
		if(s5.equals(sddd)&&s7.equals(sddd)){
			
		}else{
		s5="0"+"1"+s5;
		s7="0"+"1"+s7;
		}
		String s9=integerMultiplication(s5,s7,2*sLength);
		s9=s9.substring(1, 1+sLength);
		//进行规格化处理
		char[]cr=new char[sLength];
		//先进行舍入,因为向0舍入，直接进行截断就好
		s9=s9.substring(0,sLength);
		cr=s9.toCharArray();
		String s10=String.valueOf(cr);
		int count=0;
		String sd="";
		for(int i=0;i<sLength;i++){
			sd=sd+"0";
		}
		String klk=operand1.substring(1,1+eLength+sLength);
		String ddd=operand2.substring(1,1+eLength+sLength);
		String mnb="";
		for(int i=0;i<(eLength+sLength);i++){
			mnb=mnb+"0";
		}
		if(klk.equals(mnb)||ddd.equals(mnb)){
			s="0"+s3+mnb;
		}else
		if(s10.equals(sd)){
			s="0"+s3+s8+s10;
		}else{
		for(int i=0;i<sLength;i++){
		if(cr[i]=='1'){
			break;
		}else{
			count++;
			s10=leftShift(s10,1);
		}
		}//记录了尾数为了规格化而左移的次数
		//对阶码进行相同次数的右移
		String s16=s8.substring(0, s8.length());
		s8=logRightShift(s8,count);
		s16=logRightShift(s16,count);
		//检查溢出
		String s11=s8.substring(0, 1);
		String s12=s8.substring(1, 2);
		String s13="0";//保留溢出位
		if(s11.equals("1")&&s12.equals("1")){
			//2个有1个1都表示其溢出了;
			s13="1";
		}
		 s=s13+s3+s16+s10;
		}
		return s;
	}
	
	/**
	 * 浮点数除法，可调用{@link #integerDivision(String, String, int) integerDivision}等方法实现。<br/>
	 * 例：floatDivision("00111110111000000", "00111111000000000", 8, 8)000111111011000000
	 * @param operand1 二进制表示的被除数
	 * @param operand2 二进制表示的除数
	 * @param eLength 指数的长度，取值大于等于 4
	 * @param sLength 尾数的长度，取值大于等于 4
	 * @return 长度为2+eLength+sLength的字符串表示的相乘结果,其中第1位指示是否指数上溢（溢出为1，否则为0），其余位从左到右依次为符号、指数（移码表示）、尾数（首位隐藏）。舍入策略为向0舍入
	 */
	public String floatDivision (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		String s="";
		//判断被除数和除数是否有0
		String dp=operand1.substring(1,(1+eLength+sLength));
		String dp1=operand2.substring(1,(1+eLength+sLength));
		String dp2="";
		for(int i=0;i<(eLength+sLength);i++){
			dp2=dp2+"0";
		}
		if(dp.equals(dp2)){
			s="0"+"0"+dp2;
		}else if(dp1.equals(dp2)){
			//此时为非数
			String e="";
			for(int i=0;i<eLength;i++){
				e=e+"1";
			}
			String wei="";
			for(int i=0;i<sLength;i++){
				wei=wei+"0";
			}
			s="0"+"0"+e+wei;
		}else{
		//先得到符号位
		String s14="0";//保存溢出位
		String s1=operand1.substring(0,1);
		String s2=operand2.substring(0,1);
		String s3="";//符号位
		if(s1.equals("1")&&s2.equals("1")){
			s3="0";
		}else if(s1.equals("1")&&s2.equals("0")){
			s3="1";
		}else if(s1.equals("0")&&s2.equals("1")){
			s3="1";
		}else{
			s3="0";
		}
		//得到阶码
		String s4=operand1.substring(1,eLength+1);
		String s5=operand2.substring(1,eLength+1);
		//得到尾数
		String s6=operand1.substring(operand1.length()-sLength, operand1.length());
		String s7=operand2.substring(operand2.length()-sLength, operand2.length());
		//阶码相减
		//先得到除数的补码
		int e=1;
		for(int i=0;i<eLength-1;i++){
			e=e*2;
		}
		e=e-1;
		String lkm=integerTrueValue(s5);
		int m=Integer.parseInt(lkm);
		int difference=m-e;
		difference=-difference;
		String difference1=""+difference;
		s5=integerRepresentation(difference1,eLength);
		//进行相减的操作
		String s10=adder(s4,s5,'0',eLength);
		s10=s10.substring(1,eLength+1);
		//尾数相除
		String dd="";
		for(int i=0;i<sLength;i++){
			dd=dd+"0";
		}
		String s9="";
		if(s7.equals(dd)){
			s9=s6;
		}else{
		s6="01"+s6;
		s7="01"+s7;
		String s8=integerDivision(s6,s7,sLength);
		s9=s8.substring(1,1+sLength);
		}
	    s=s14+s3+s10+s9;
		}
		return s;
	}
}