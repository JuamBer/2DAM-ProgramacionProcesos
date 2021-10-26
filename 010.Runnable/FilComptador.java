


public class FilComptador implements Runnable{
	
	private long comptador;
	private boolean parar;
	private int fil;
	private String btnv;
	private Button btn;
	
	public FilComptador(long comptador,String btnv,int fil){
		this.comptador = comptador;
		this.fil = fil;
		this.parar = false;
		this.btnv = btnv;
	}
	
	public static void pararContador(){
		
	}
	
	public long sumComptador(){
		return this.comptador++;
	}
	public long getComptador(){
		return this.comptador;
	}
	
	public boolean getParar(){
		return this.parar;
	}
	
	public int getFil(){
		return this.fil;
	}
	
	public String getBtn(){
		return this.btn;
	}
	
	public void init(){
		setBackground(Color.yellow);
		
		add(this.btn = new Button(this.btnv);
		b1.addActionListener(this);
		
		this.fuente = new Font("Verdana", Font.BOLD,26);
	}
	
	public void start(){
	}
	
	public void run(){
		Thread filActual=Thread.currentThread();
		while(this.h==filActual && !this.comp1.getParar()){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){ System.out.println(ex.getMessage()); }
			
			repaint();
			this.comp1.sumComptador();
		}
	}
	
	public void stop(){
		this.h = null;
	}
	
	public void paint(Graphics g){
		g.setFont(this.fuente);
		g.drawString(Long.toString((long) this.comp1.getComptador()),80,100);
	}
	
	public void actionPerformed(ActionEvent e){
		//this.b1.setLabel("Continuar");
		//
		//if(e.getSource()==this.b1){
		//	if(this.h != null && this.h.isAlive()){
		//	}else{
		//		this.h = new Thread(this);
		//		this.h.start();
		//	}
		//}else if(e.getSource()==this.b2){
		//	this.parar=true;
		//}
	}
	
	
}


