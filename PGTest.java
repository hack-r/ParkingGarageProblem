package pg; 

public class PGTest {

	public static void main(String[] args) {
		SaturnSL1 sl     = new SaturnSL1();
		HondaCivic hc    = new HondaCivic();
		//Japanese jp = new Japanese(); // Doesn't compile
		Japanese jp      = null;
		German gr        = new MercedesC230();
		//ChevyS10 cs      = new Truck(); // Doesn't compile
		ChevyS10 cs      = null;
		SubaruOutback sb = new SubaruOutback();
		Domestic dm      = sl;
		//dm               = hc;
		//dm               = null;
		//dm               = (Domestic) hc;
		//dm               = cs;
		//dm               = (Domestic) cs;
		Import im        = sb;
		gr               = null;
		//gr               = (German) im;
		//jp               = im;
		//jp               = (German) im;
		//jp               = (Japanese) im;
		//Automobile a     = cs;
		//a                = hc;
		
		System.out.println(sl);
		System.out.println(hc);
		System.out.println(jp);
		System.out.println(gr);
		System.out.println(cs);
		System.out.println(sb);
		System.out.println(dm);
		System.out.println(im);
		//System.out.println(a);
		
		//System.out.println(gr.getWeightInPounds());
	}

}
