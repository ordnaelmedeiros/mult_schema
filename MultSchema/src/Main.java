import java.util.Date;

public class Main {

	public static void imprimeSoma(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v0) {
		String vv = v1+v2+v3+v4+v5+v6+v7+v8+v9+v0;
		//System.out.println(vv);
	}
	
	public static void imprimeBuilder(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v0) {
		String vv = new StringBuilder().append(v1).append(v2).append(v3).append(v4).append(v5).append(v6).append(v7).append(v8).append(v9).append(v0).toString();
		//System.out.println(vv);
	}
	
	public static void imprimeBuffer(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v0) {
		String vv = new StringBuffer().append(v1).append(v2).append(v3).append(v4).append(v5).append(v6).append(v7).append(v8).append(v9).append(v0).toString();
		//System.out.println(vv);
	}
	
	public static void imprimeConcat(String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8, String v9, String v0) {
		String vv = v1.concat(v2).concat(v3).concat(v4).concat(v5).concat(v6).concat(v7).concat(v8).concat(v9).concat(v0);
		//System.out.println(vv);
	}
	
	
	public static void imprimeSoma2(String v1, String v2) {
		String vv = v1+v2;
		//System.out.println(vv);
	}
	
	public static void imprimeBuilder2(String v1, String v2) {
		String vv = new StringBuilder().append(v1).append(v2).toString();
		//System.out.println(vv);
	}
	
	public static void imprimeBuffer2(String v1, String v2) {
		String vv = new StringBuffer().append(v1).append(v2).toString();
		//System.out.println(vv);
	}
	
	public static void imprimeConcat2(String v1, String v2) {
		String vv = v1.concat(v2);
		//System.out.println(vv);
	}
	
	public static void main(String[] args) {
		
		String v1 = "v12";
		String v2 = "v23";
		String v3 = "v34";
		String v4 = "v45";
		String v5 = "v56";
		String v6 = "v67";
		String v7 = "v78";
		String v8 = "v89";
		String v9 = "v90";
		String v0 = "v01";
		
		Date d0 = null;
		Date d1 = null;
		Date d2 = null;
		Date d3 = null;
		Date d4 = null;
		Date d5 = null;
		Date d6 = null;
		Date d7 = null;
		Date d8 = null;
		Date d9 = null;
		
		int limite10Strings = 1000000;
		int limite2Strings = 5000000;
		
		d0 = new Date();
		d1 = new Date();
		for (int i=0; i<limite10Strings; i++) {
			imprimeBuilder(v1, v2, v3, v4, v5, v6, v7, v8, v9, v0);
		}
		d2 = new Date();
		for (int i=0; i<limite10Strings; i++) {
			imprimeBuffer(v1, v2, v3, v4, v5, v6, v7, v8, v9, v0);
		}
		d3 = new Date();
		for (int i=0; i<limite10Strings; i++) {
			imprimeSoma(v1, v2, v3, v4, v5, v6, v7, v8, v9, v0);
		}
		d4 = new Date();
		for (int i=0; i<limite10Strings; i++) {
			imprimeConcat(v1, v2, v3, v4, v5, v6, v7, v8, v9, v0);
		}
		d5 = new Date();
		for (int i=0; i<limite2Strings; i++) {
			imprimeBuilder2(v1, v2);
		}
		d6 = new Date();
		for (int i=0; i<limite2Strings; i++) {
			imprimeBuffer2(v1, v2);
		}
		d7 = new Date();
		for (int i=0; i<limite2Strings; i++) {
			imprimeSoma2(v1, v2);
		}
		d8 = new Date();
		for (int i=0; i<limite2Strings; i++) {
			imprimeConcat2(v1, v2);
		}
		d9 = new Date();
		
		System.out.println("Usando 10 Strings:");
		
		System.out.println("StringBuilder.: " + (d2.getTime()-d1.getTime()));
		System.out.println("StringBuffer..: " + (d3.getTime()-d2.getTime()));
		System.out.println("Somando String: " + (d4.getTime()-d3.getTime()));
		System.out.println("Concatenando..: " + (d5.getTime()-d4.getTime()));
		
		System.out.println("\nUsando 2 Strings:");
		
		System.out.println("StringBuilder.: " + (d6.getTime()-d5.getTime()));
		System.out.println("StringBuffer..: " + (d7.getTime()-d6.getTime()));
		System.out.println("Somando String: " + (d8.getTime()-d7.getTime()));
		System.out.println("Concatenando..: " + (d9.getTime()-d8.getTime()));
		
	}
	
}