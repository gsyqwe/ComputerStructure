package bighomework;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ģ��ALU���������͸���������������
 * @author 161250032_��ʫ��
 *
 */

public class ALU {
	/**
	 * ����ʮ���������Ķ����Ʋ����ʾ��<br/>
	 * ����integerRepresentation("9", 8)
	 * @param number ʮ������������Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param length �����Ʋ����ʾ�ĳ���
	 * @return number�Ķ����Ʋ����ʾ������Ϊlength
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
	 * ����ʮ���Ƹ������Ķ����Ʊ�ʾ��
	 * ��Ҫ���� 0������񻯡����������+Inf���͡�-Inf������ NaN�����أ������� IEEE 754��
	 * �������Ϊ��0���롣<br/>
	 * ����floatRepresentation("11.375", 8, 11)
	 * @param number ʮ���Ƹ�����������С���㡣��Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return number�Ķ����Ʊ�ʾ������Ϊ 1+eLength+sLength���������ң�����Ϊ���š�ָ���������ʾ����β������λ���أ�
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
		}//���������,����������������޷��ú�ʹ�ã�������ѡ��û�бȽ���Ϊ�Ƚ��������ʹ�����޷�����
		for(int t=0;t<eLength;t++){
			length2=length2*2;
		}
		for(int t=0;t<eLength;t++){
			border3=border3/2;//��������ǹ�񻯵Ľ���
		}//�ǹ����ʮ��С��Ҳ����ˡ�������û�취�����Ƚ��˳����ܲ�������
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
				//�ǹ����
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
			b=h-m;//С������
			int e=1;
			int count=0;
			int c3=0;
			for(int k=0;k<eLength-1;k++){
			    	e=e*2;//�õ�����ƫ����
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
			b=h-m;//С������
			int e=1;
			int count=0;
			int c3=0;
			for(int k=0;k<eLength-1;k++){
			    	e=e*2;//�õ�����ƫ����
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
	 * ����ʮ���Ƹ�������IEEE 754��ʾ��Ҫ�����{@link #floatRepresentation(String, int, int) floatRepresentation}ʵ�֡�<br/>
	 * ����ieee754("11.375", 32)
	 * @param number ʮ���Ƹ�����������С���㡣��Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 * @param length �����Ʊ�ʾ�ĳ��ȣ�Ϊ32��64
	 * @return number��IEEE 754��ʾ������Ϊlength���������ң�����Ϊ���š�ָ���������ʾ����β������λ���أ�
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
	 * ��������Ʋ����ʾ����������ֵ��<br/>
	 * ����integerTrueValue("00001001")
	 * @param operand �����Ʋ����ʾ�Ĳ�����
	 * @return operand����ֵ����Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ
	 */
	public String integerTrueValue (String operand) {
		// TODO YOUR CODE HERE.
		String s="";
		String s1=operand.substring(0, 1);
		String s2=operand.substring(1, operand.length());
		//����������ͷ���
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
	 * ���������ԭ���ʾ�ĸ���������ֵ��<br/>
	 * ����floatTrueValue("01000001001101100000", 8, 11)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return operand����ֵ����Ϊ���������һλΪ��-������Ϊ������ 0�����޷���λ����������ֱ��ʾΪ��+Inf���͡�-Inf���� NaN��ʾΪ��NaN��
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
		//����������ͷ���
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
		else{//����С��0������
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
			//����Ϊ0�����
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
	 * ��λȡ��������<br/>
	 * ����negation("00001001")
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @return operand��λȡ���Ľ��
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
	 * ���Ʋ�����<br/>
	 * ����leftShift("00001001", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand����nλ�Ľ��
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
	 * �߼����Ʋ�����<br/>
	 * ����logRightShift("11110110", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand�߼�����nλ�Ľ��
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
	 * �������Ʋ�����<br/>
	 * ����logRightShift("11110110", 2)
	 * @param operand �����Ʊ�ʾ�Ĳ�����
	 * @param n ���Ƶ�λ��
	 * @return operand��������nλ�Ľ��
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
	 * ȫ����������λ�Լ���λ���мӷ����㡣<br/>
	 * ����fullAdder('1', '1', '0')
	 * @param x ��������ĳһλ��ȡ0��1
	 * @param y ������ĳһλ��ȡ0��1
	 * @param c ��λ�Ե�ǰλ�Ľ�λ��ȡ0��1
	 * @return ��ӵĽ�����ó���Ϊ2���ַ�����ʾ����1λ��ʾ��λ����2λ��ʾ��
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
	 * 4λ���н�λ�ӷ�����Ҫ�����{@link #fullAdder(char, char, char) fullAdder}��ʵ��<br/>
	 * ����claAdder("1001", "0001", '1')
	 * @param operand1 4λ�����Ʊ�ʾ�ı�����
	 * @param operand2 4λ�����Ʊ�ʾ�ļ���
	 * @param c ��λ�Ե�ǰλ�Ľ�λ��ȡ0��1
	 * @return ����Ϊ5���ַ�����ʾ�ļ����������е�1λ�����λ��λ����4λ����ӽ�������н�λ��������ѭ�����
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
	 * ��һ����ʵ�ֲ�������1�����㡣
	 * ��Ҫ�������š����š�����ŵ�ģ�⣬
	 * ������ֱ�ӵ���{@link #fullAdder(char, char, char) fullAdder}��
	 * {@link #claAdder(String, String, char) claAdder}��
	 * {@link #adder(String, String, char, int) adder}��
	 * {@link #integerAddition(String, String, int) integerAddition}������<br/>
	 * ����oneAdder("00001001")
	 * @param operand �����Ʋ����ʾ�Ĳ�����
	 * @return operand��1�Ľ��������Ϊoperand�ĳ��ȼ�1�����е�1λָʾ�Ƿ���������Ϊ1������Ϊ0��������λΪ��ӽ��
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
		}//s1Ϊ��λ
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
	 * �ӷ�����Ҫ�����{@link #claAdder(String, String, char)}����ʵ�֡�<br/>
	 * ����adder("0100", "0011", ��0��, 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param c ���λ��λ
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����ӽ��
	 */
	public String adder (String operand1, String operand2, char c, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String s4="";//�õ�����λ
		//��2����������Ϊ����Ϊlength����
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
	 * �����ӷ���Ҫ�����{@link #adder(String, String, char, int) adder}����ʵ�֡�<br/>
	 * ����integerAddition("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����ӽ��
	 */
	public String integerAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		char c='0';
		String sm="";//�������λ
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
	 * �����������ɵ���{@link #adder(String, String, char, int) adder}����ʵ�֡�<br/>
	 * ����integerSubtraction("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ļ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ��������
	 */
	public String integerSubtraction (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String sm="";//�������λ
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
	 * �����˷���ʹ��Booth�㷨ʵ�֣��ɵ���{@link #adder(String, String, char, int) adder}�ȷ�����<br/>
	 * ����integerMultiplication("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ĳ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊlength+1���ַ�����ʾ����˽�������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������lengthλ����˽��
	 */
	public String integerMultiplication (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		String skl=operand1.substring(0,1);
		String sml=operand2.substring(0,1);
		String s1="";//�������λ
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
		x=operand1.toCharArray();//��operand1����������
		z=operand2.toCharArray();//��operand2��������
		//���-operand1�Ĳ���
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
	    String operand4=String.valueOf(x);//�õ�-x�����ַ���
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
            //�����������
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
	 * �����Ĳ��ָ������������ɵ���{@link #adder(String, String, char, int) adder}�ȷ���ʵ�֡�<br/>
	 * ����integerDivision("0100", "0011", 8)
	 * @param operand1 �����Ʋ����ʾ�ı�����
	 * @param operand2 �����Ʋ����ʾ�ĳ���
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ���ĳ���������ĳ���С��lengthʱ����Ҫ�ڸ�λ������λ
	 * @return ����Ϊ2*length+1���ַ�����ʾ�������������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0�������lengthλΪ�̣����lengthλΪ����
	 */
	public String integerDivision (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String m1=alu.integerTrueValue(operand1);//operand1�Ǳ�����
		String m2=alu.integerTrueValue(operand2);//operand2�ǳ���
		int h1=Integer.parseInt(m1);//h1�Ǳ�����
		int h2=Integer.parseInt(m2);//h2�ǳ���
		String s="";
		char[]cr=new char[operand2.length()];
		String s1="";//�õ������Ĳ���
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
		if(h2==0&&h1!=0){//����������0��������0
			s="error";
		}else if(h1==0&&h2==0){//��������0������Ҳ��0
			s="NaN";
		}else if(h1>h2){//�������ȳ���С
			if(h1>0&&h2>0){//����������0����������0�����
				//����һ���������Գ���ȡ���������������,��ʱ���ᷢ�����
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
			//�õ������Ĳ��룬����������������
            int count=1;//��count������һ���ܼ����Σ��õ���
            //�õ��̵����ֵ
            int division=1;
            for(int i=0;i<length;i++){
            	division=division*2;
            }
            String s4="";
            s4=operand1;
            for(;count<division;count++){
			s4=alu.adder(s4, s1, '0', length);
			s4=s4.substring(1, s4.length());
			String m3=alu.integerTrueValue(s4);//�õ������Ľ��
			int h3=Integer.parseInt(m3);//�����ȥ�Ľ����������бȽ�
			if(h3<h2){//���h3�ȳ���С��˵��h3������
				s=s+s4;//�����������
				break;//����ѭ��
			}
            }
            //count������Ĵ�����Ҳ������
            //��countת��Ϊ2���Ƶ��õ�һ������
            String hm=String.valueOf(count);
            String s5=alu.integerRepresentation(hm, length);//�õ�8λ����
            s="0"+s5+s;
		}else if(h1>0&&h2<0){//����������0������С��0
			//��ʱ���Ǹ���,�ȵõ�2���������̵Ľ��Ȼ��ȡ��
			//��ʱ��������ȡ��,��ʱ�Ƚ�h2�ľ�����h1˭��˭С
			h2=-h2;
			if(h1>h2){
			int count=1;//��count������һ���ܼ����Σ��õ���
			int division=1;
			for(int i=0;i<length;i++){
            	division=division*2;
            }
			String s4="";
			s4=operand1;
			for(;count<division;count++){
					s4=alu.adder(s4, operand2, '0', length);
					s4=s4.substring(1, s4.length());
					String m3=alu.integerTrueValue(s4);//�õ������Ľ��
					int h3=Integer.parseInt(m3);//�����ȥ�Ľ����������бȽ�
					if(h3<h2){//���h3�ȳ���С��˵��h3������
						s=s+s4;//�����������
						break;
					}
			}
			//count������Ĵ�����Ҳ������
	            //��countת��Ϊ2���Ƶ��õ�һ������
	            String hm=String.valueOf(count);
	            String s5=alu.integerRepresentation(hm, length);//�õ�8λ����
	            //����ȡ��
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
				//h1��h2�ľ���ֵС
			    //��ʱ��Ϊ0
				s="0"+s;
				for(int i=0;i<length;i++){
					s=s+"0";//��ȫ��0
				}
				//operand2ֱ��Ϊ����
				s=s+operand2;
			}
		}
		}else if(h1<h2){
			if(h1>0&&h2>0){
				s="0"+s;
				for(int i=0;i<length;i++){
					s=s+"0";//��ȫ��0
				}
				//operand2ֱ��Ϊ����
				s=s+operand2;
			}else if(h1<0&&h2>0){
				//�Ƚ�h1�ľ�����h2�Ĵ�С
				h1=-h1;
				if(h1>h2){//h1�ľ���ֵ��h2��
					//��h1ȡ�����ٶ�h2Ҳȡ�����õ�����ȡ�����õ���ȷ�Ľ����
					char[]cn=new char[s1.length()];
					cn=operand1.toCharArray();//��operand1ȡ��
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
					//��operand2ȡ��
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
					//��������������õ��̵Ĳ���
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
						String m3=alu.integerTrueValue(s4);//�õ������Ľ��
						int h3=Integer.parseInt(m3);//�����ȥ�Ľ����������бȽ�
						if(h3<h2){//���h3�ȳ���С��˵��h3������
							s=s+s4;//�����������
							break;//����ѭ��
						}
					}
					//�õ��̣�����ȡ��
					  //count������Ĵ�����Ҳ������
		            //��countת��Ϊ2���Ƶ��õ�һ������
		            String hm=String.valueOf(count);
		            String s5=alu.integerRepresentation(hm, length);//�õ�8λ����
		            //����ȡ��
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
				}else if(h1<h2){//h1�ľ���ֵ��h2С������Ϊ0����Ϊh2
					s="0"+s;
					for(int i=0;i<length;i++){
						s=s+"0";
					}
					s=s+operand2;
				}
			}else if(h1<0&&h2<0){
				//h1<h2�Ҷ�С��0��˵��h1�ľ���ֵ����h2�ľ���ֵ
				//ֱ��תΪ��������������
				//��ʱ��Ψһ��������η���
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
				//��ʱh1>h2
				//����һ���������Գ���ȡ���������������,��ʱ���ᷢ�����
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
				//�õ������Ĳ��룬����������������
	            int count=1;//��count������һ���ܼ����Σ��õ���
	            //�õ��̵����ֵ
	            int division=1;
	            for(int i=0;i<length;i++){
	            	division=division*2;
	            }
	            String s4="";
	            s4=operand1;
	            for(;count<division;count++){
				s4=alu.adder(s4, s1, '0', length);
				s4=s4.substring(1, s4.length());
				String m3=alu.integerTrueValue(s4);//�õ������Ľ��
				int h3=Integer.parseInt(m3);//�����ȥ�Ľ����������бȽ�
				if(h3<h2){//���h3�ȳ���С��˵��h3������
					s=s+s4;//�����������
					break;//����ѭ��
				}
	            }
	            //count������Ĵ�����Ҳ������
	            //��countת��Ϊ2���Ƶ��õ�һ������
	            String hm=String.valueOf(count);
	            String s5=alu.integerRepresentation(hm, length);//�õ�8λ����
	            s="0"+s5+s;
				}
			}
		}
		return s;
	}
	
	/**
	 * �����������ӷ������Ե���{@link #adder(String, String, char, int) adder}�ȷ�����
	 * ������ֱ�ӽ�������ת��Ϊ�����ʹ��{@link #integerAddition(String, String, int) integerAddition}��
	 * {@link #integerSubtraction(String, String, int) integerSubtraction}��ʵ�֡�<br/>
	 * ����signedAddition("1100", "1011", 8)
	 * @param operand1 ������ԭ���ʾ�ı����������е�1λΪ����λ
	 * @param operand2 ������ԭ���ʾ�ļ��������е�1λΪ����λ
	 * @param length ��Ų������ļĴ����ĳ��ȣ�Ϊ4�ı�����length��С�ڲ������ĳ��ȣ����������ţ�����ĳ���������ĳ���С��lengthʱ����Ҫ���䳤����չ��length
	 * @return ����Ϊlength+2���ַ�����ʾ�ļ����������е�1λָʾ�Ƿ���������Ϊ1������Ϊ0������2λΪ����λ����lengthλ����ӽ��
	 */
	public String signedAddition (String operand1, String operand2, int length) {
		// TODO YOUR CODE HERE.
		ALU alu=new ALU();
		String s="";
		String s7="";//���λ
		String s8="";//����λ
		String s9="";//���λ
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
	 * �������ӷ����ɵ���{@link #signedAddition(String, String, int) signedAddition}�ȷ���ʵ�֡�<br/>
	 * ����floatAddition("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ļ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param gLength ����λ�ĳ���
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����ӽ�������е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatAddition (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		//ָ������λ
		String s10="0";
        String s="";
        //�Խ�
        ALU alu=new ALU();
        //�õ�����λ
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
        //�õ��ײ�
        //�õ�β��
        String s5=operand1.substring(operand1.length()-sLength,operand1.length());
        String s6=operand2.substring(operand2.length()-sLength,operand2.length());
        if(s8.equals("0")&&s9.equals("0")){
        	//�ӷ�
        	s7="0";
        	if(difference>0){
        		//operand2��С��
        		//��operand2��β����������
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        	//�ӷ�
        	s7="1";
        	if(difference>0){
        		//operand2��С��
        		//��operand2��β����������
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        	//����
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
        		//operand2��С��
        		//��operand2��β����������
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s2=alu.adder(s2, dlk, '0', eLength);
        			s2=s2.substring(1,s2.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        	//����
        	//��s6��β��ȡ��
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
        		//operand2��С��
        		//��operand2��β����������
        		s6=alu.logRightShift(s6, difference);
        		String result=alu.adder(s5, s6, '0', sLength);
        		String sk=result.substring(0,1);
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
        		//��β���Ƿ�����������������
        		if(sk.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
        			String dlk="";
        			for(int i=0;i<eLength;i++){
        				dlk=dlk+"1";
        			}
        			s1=alu.adder(s1, dlk, '0', eLength);
        			s1=s1.substring(1,s1.length());
        		}
        		String sd=result.substring(1,2);
        		//����һλΪ1��������
        		if(sd.equals("1")){
        			result=alu.logRightShift(result, 1);
        			//�����1
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
	 * �������������ɵ���{@link #floatAddition(String, String, int, int, int) floatAddition}����ʵ�֡�<br/>
	 * ����floatSubtraction("00111111010100000", "00111111001000000", 8, 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ļ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param gLength ����λ�ĳ���
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ�������������е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatSubtraction (String operand1, String operand2, int eLength, int sLength, int gLength) {
		// TODO YOUR CODE HERE.
		String s="";
		//�Լ���ȡ������floatAddition
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
	 * �������˷����ɵ���{@link #integerMultiplication(String, String, int) integerMultiplication}�ȷ���ʵ�֡�<br/>
	 * ����floatMultiplication("00111110111000000", "00111111000000000", 8, 8)
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ĳ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����˽��,���е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatMultiplication (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		//�ȵõ�����λ
		//�������˷���������ӣ�β�����
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
		//���������
		//operand1������
		//operand2�Ľ���תΪ����
		String truth=integerTrueValue(s6);
		//�õ�ƫ����
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
		//β�����
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
		//���й�񻯴���
		char[]cr=new char[sLength];
		//�Ƚ�������,��Ϊ��0���룬ֱ�ӽ��нضϾͺ�
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
		}//��¼��β��Ϊ�˹�񻯶����ƵĴ���
		//�Խ��������ͬ����������
		String s16=s8.substring(0, s8.length());
		s8=logRightShift(s8,count);
		s16=logRightShift(s16,count);
		//������
		String s11=s8.substring(0, 1);
		String s12=s8.substring(1, 2);
		String s13="0";//�������λ
		if(s11.equals("1")&&s12.equals("1")){
			//2����1��1����ʾ�������;
			s13="1";
		}
		 s=s13+s3+s16+s10;
		}
		return s;
	}
	
	/**
	 * �������������ɵ���{@link #integerDivision(String, String, int) integerDivision}�ȷ���ʵ�֡�<br/>
	 * ����floatDivision("00111110111000000", "00111111000000000", 8, 8)000111111011000000
	 * @param operand1 �����Ʊ�ʾ�ı�����
	 * @param operand2 �����Ʊ�ʾ�ĳ���
	 * @param eLength ָ���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @param sLength β���ĳ��ȣ�ȡֵ���ڵ��� 4
	 * @return ����Ϊ2+eLength+sLength���ַ�����ʾ����˽��,���е�1λָʾ�Ƿ�ָ�����磨���Ϊ1������Ϊ0��������λ����������Ϊ���š�ָ���������ʾ����β������λ���أ����������Ϊ��0����
	 */
	public String floatDivision (String operand1, String operand2, int eLength, int sLength) {
		// TODO YOUR CODE HERE.
		String s="";
		//�жϱ������ͳ����Ƿ���0
		String dp=operand1.substring(1,(1+eLength+sLength));
		String dp1=operand2.substring(1,(1+eLength+sLength));
		String dp2="";
		for(int i=0;i<(eLength+sLength);i++){
			dp2=dp2+"0";
		}
		if(dp.equals(dp2)){
			s="0"+"0"+dp2;
		}else if(dp1.equals(dp2)){
			//��ʱΪ����
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
		//�ȵõ�����λ
		String s14="0";//�������λ
		String s1=operand1.substring(0,1);
		String s2=operand2.substring(0,1);
		String s3="";//����λ
		if(s1.equals("1")&&s2.equals("1")){
			s3="0";
		}else if(s1.equals("1")&&s2.equals("0")){
			s3="1";
		}else if(s1.equals("0")&&s2.equals("1")){
			s3="1";
		}else{
			s3="0";
		}
		//�õ�����
		String s4=operand1.substring(1,eLength+1);
		String s5=operand2.substring(1,eLength+1);
		//�õ�β��
		String s6=operand1.substring(operand1.length()-sLength, operand1.length());
		String s7=operand2.substring(operand2.length()-sLength, operand2.length());
		//�������
		//�ȵõ������Ĳ���
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
		//��������Ĳ���
		String s10=adder(s4,s5,'0',eLength);
		s10=s10.substring(1,eLength+1);
		//β�����
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