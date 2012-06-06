public class RajamantriChorSipahi extends Activity {

    protected void onPostResume() {
	// TODO Auto-generated method stub
	super.onPostResume();
    }
    
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
	AlertDialog dialog = new AlertDialog.Builder(this).create();
	dialog.setTitle("Exit game!");
	dialog.setMessage("Are you sure you want to exit the game?");
	dialog.setButton("Exit", new DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
		    
		    finish();
		    
		}
	    });
	dialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
		    
		    dialog.dismiss();
		    
		}
	    });
	dialog.show();
	return super.onKeyDown(keyCode, event);
    }
    
    
    public void onLowMemory() {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
	dialog.setTitle("Low memory!");
	dialog.setMessage("Too many apps open, kindly close some other apps and try again!");
	dialog.setButton("Exit", new DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
		    
		    finish();
		    
		}
	    });
	
	dialog.show();
	
	
	super.onLowMemory();
    }
    
    
    protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
    }
    
    String[] solutionArray = { "RAJA", "MANTRI", "CHOR", "SIPAHI"};
    String[] playersArray = {"Player1", "Player2", "Player3", "Player4"};
    static String player_name = new String[4] ;
    static String player_role = new String[4];
    static boolean guess = false;
    static String player = new String[4];
    static int i=0,j=0,k=0,l=0;
    static int pScore = new int[4] ;
    int count = 0;
    
    Button btnRajaMantri;
    Button btnHelp;
    ImageView btn9;
    Button btnPlay;
    static Button btnPod=new Button[4];
    Button btnShowResult;
    Button btnRestart;
    Button btnSignin;
    Button btnGuess;
    EditText editTxtPlayer = new EditText[4];
    EditText edt = EditText[4];
    
    TextView lblPlayer= new TextView[4];
    static TextView txtTurn;
    static TextView txtPlayer = new TextView[4];
    Bundle savedInstanceState2;
    Button btnMainMenu;
    
    String nextTurn = "";
    
    
    public void onRestart(){
	
    	super.onRestart();    	
    	
    }
    
    public void onResume(){
	
    	super.onResume();
    	
    }
    
    

    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
	
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        btnHelp = (Button)findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(new OnClickListener() {
		
	    public void onClick(View v) {
		setContentView(R.layout.help);
		// Create the adView
		AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
		// Lookup your LinearLayout assuming it’s been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayoutHelp);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());
		TextView txtHelp = (TextView)findViewById(R.id.txtHelp);
		String text = "Welcome to nostalgia! This is the paper free version of Raja Mantri Chor Sipahi.\n\nThe game involves bluffing with facial expressions and good guessing. This is a very popular childhood game in India played among kids often during their long summer vacations.\n\nThe game has 4 paper chits with Chor (thief), Sipahi (police), Raja (king) and Mantri (minister). The chits are folded at the start of the game and one of the 4 players will press SHUFFLE each one of the four players is supposed to secretly (by taking the phone and not letting the others see it)pick one chit by clicking on it, the player then clicks on the chit again to fold it back. All the players will then secretly open their chits and read what they have got. \n\nThe player who gets the chit with Raja written on it will say MERA MANTRI KAUN? (Who is my minister?). The player who got the chit with Mantri will say MEIN! (Me), The player with Raja will then say CHOR SIPAHI KA PATA LAGAO (find out who is the theif and who is the soldier). The player with Mantri will then guess who is the Chor (Thief), if he is wrong then his points are deducted and if he is correct he gets more points and the points from the player who got Chor (Thief) are deducted.\n\nIf the guess is correct the player with Chor is wrapped on his wrist by the Mantri, and if the Mantri is wrong then the Chor gets to hit his wrist.";
		txtHelp.setText(text);
		Button btnBack = (Button)findViewById(R.id.btnMainMenuHelp);
		btnBack.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			
			    Intent i = new Intent(RajaMantri.this, RajaMantri.class);
			    RajaMantri.this.startActivity(i);
			    finish();
			    
			}
		    });
	    }
	    });
        btnRajaMantri = (Button) findViewById(R.id.btnRajaMantri);
        btnRajaMantri.setOnClickListener(new OnClickListener() {
		
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		setContentView(R.layout.rmcsp); // Create the adView
		AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");  
		// Lookup your LinearLayout assuming it’s been given  the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayoutPlayer); 
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());
		for(int i = 0 ; i<4 ; i++)
		{
		    editTxtPlayer[i] = (EditText) findViewById(R.id.editTxtPlayer[i]);
	      	    lblPlayer[i] = (TextView) findViewById(R.id.lblPlayer[i]);
		}	
		Display display = getWindowManager().getDefaultDisplay(); 
		int width = display.getWidth();
		int height = display.getHeight();
		
		
		for(i = 0 ; i<4 ; i++)
		{		
	            lblPlayer[i].setGravity(Gravity.CENTER_HORIZONTAL);
		    Log.v("AkandBakar", "Playernames:" + player_name[i]);
		}
		btnMainMenu = (Button) findViewById(R.id.btnMainMenu);
		btnMainMenu.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
			Intent i = new Intent(RajaMantri.this, RajaMantri.class);
			RajaMantri.this.startActivity(i);
			finish();
			
		    }
		    });
		
		btnSignin = (Button) findViewById(R.id.btnsignin);
		btnSignin.setOnClickListener(new OnClickListener() {
			
		    public void onClick(View v) {
			// TODO Auto-generated method stub
			for(int i = 0 ; i<4 ; i++){
			player_name[i] = editTxtPlayer[i].getText().toString();
			}			
			
			if(player_name[0].equals("")||player_name[1].equals("")||player_name[2].equals("")||player_name[3].equals("")){
			    
			    Toast toast = Toast.makeText(getBaseContext(), "Enter player names!", 8000);
			    toast.show();
			    
			}else{
			    setContentView(R.layout.rmcsgnew);
			    // Create the adView
			    AdView adView = new AdView(RajaMantri.this, AdSize.BANNER, "a14e156523d01de");
			    // Lookup your LinearLayout assuming it’s been given  , the attribute android:id="@+id/mainLayout"
			    LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout); // Add the adView to it
			    layout.addView(adView);// Initiate a generic request to load it with an ad
			    adView.loadAd(new AdRequest());
			    txtTurn = (TextView)findViewById(R.id.txtTurn);
			    txtTurn.setText("Click on SHUFFLE!");
			    
			    
 		            for(int i = 0 ; i<4 ; i++){
			    txtPlayer[i] = (TextView) findViewById(R.id.txtPlayer[i]);
			    txtPlayer[i].setText("1."+player_name[i] + " [" + pScope[i] + "]");
			    }
			    
			    btnPlay = (Button) findViewById(R.id.btnPlay);
			    
			    btnPlay.setOnClickListener(new OnClickListener() {
				    
			        public void onClick(View v) { // TODO Auto-generated method stub
				    
				    if(btnPlay.getText().equals("SHUFFLE")){
					
					RajaMantri.this.shuffle();
		 			
				    }else{
					
		 			
					RajaMantri.this.makeGuess();
					for(int i = 0 ; i<4 ; i++){
					Log.v("RajaMantri", "########## Player Name:" + player_name[i] +" Role:" + player_role[i]);	
					}
					
				    }
				    
				    
				}
		 		});
		         
			    
			
 	
	
    }
    
    
    public void makeGuess(){
	
    	btnPlay.setText("SHUFFLE");
	count = 0;
	btnPlay.setText("SHUFFLE");
	for(int i = 0 ; i<4 ; i++){
	    btnPod[i].setClickable(true);
	}	
	for(int i = 0 ; i<4 ; i++)
      	    if(player[i].equals("RAJA")){
	    
	        btnPod[i].setText("RAJA");
	        btnPod[i].setBackgroundResource(R.drawable.podopen);
	        btnPod[i].setClickable(false);
	}
	
	
	for(int i = 0 ; i<4 ; i++)
	if(player_role[i].equals("MANTRI")){
	    txtTurn.setText(player_name[i] + " will find the CHOR!");
	}
	
	
	Log.v("AkhandBakar","#########" + btnPod[0].getText());
	for(int j = 0 ; j<4 ; j++){
	if(btnPod1.getText().equals("")){
	    
	    btnPod1.setOnClickListener(new OnClickListener() {
		    
		    
	         public void onClick(View v) {
		     // TODO Auto-generated method stub
		     Log.v("AkhandBakar","#########" + player[0]);
		     if(player[j].equals("CHOR")){
			 
			 RajaMantri.guess = true;
			 btnPod[j].setBackgroundResource(R.drawable.podopen);
			 btnPod[j].setText("CHOR");
			 
		     }else{
			 
			 RajaMantri.guess = false;
			 btnPod[j].setBackgroundResource(R.drawable.podopen);
			 btnPod[j].setText("SIPAHI");
		     }
		     for(int i = 0 ; i<4 ; i++){
		     	btnPod[i].setClickable(false);
		     }
		     updateScore();
				}
		});
	}	
	
	
	Log.v("AkhandBakar","#########" + btnPod[j].getText());
	}
	
    }
    
    
    public void shuffle(){
	
    	btnPlay.setText("Guess");
	btnPlay.setClickable(false);
	shuffleArray(solutionArray);
	txtTurn.setText(player_name[0] + "'s" + " turn!");
	nextTurn = player_name[1];
	
                for(int j = 0 ; j<4 ; j++)  
                for(int i = j ; i<4 ; i++)
		{
 	 	btnPod[j] = (Button)findViewById(R.id.btnPod1);
	        btnPod[j].setBackgroundResource(R.drawable.podtlclosed);
	        btnPod[j].setOnClickListener(new OnClickListener() {
		
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		player[j] = solutionArray[j];
		btnPod[j].setText(player1);
		btnPod[j].setBackgroundResource(R.drawable.podopen);
		for(int i = 1 ; i<4 ; i++){
		    btnPod[i].setClickable(false);
		 } 
		if(txtTurn.getText().equals(player_name[i] + "'s" + " turn!")){
		    
		    if(player[j].equals("MANTRI")){
			
			player_role[i] = "MANTRI";
		    }
		    if(player[j].equals("RAJA")){
							
			player_role[i] = "RAJA";
		    }
		    if(player[j].equals("SIPAHI")){
			
			player_role[i] = "SIPAHI";
		    }
		    if(player[j].equals("CHOR")){
			
			player_role[i] = "CHOR";
		    }
		    
		    if((i+1)==4)
			 nextTurn = "Click on Guess!";
		    else
		         nextTurn = player_name[i+1] + "'s" + " turn!";
		    }
		}//end middle for
		
		
		
		txtTurn.setText("Click again to close the chit!");
		
		
		
		btnPod[j].setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
			    // TODO Auto-generated method stub
                            count++;
			    for(int i=0;i<4;i++){
			     if(i==j)
				{
			        btnPod[i].setClickable(false);
			        
			        btnPod[i].setText("");
			        btnPod[i].setBackgroundResource(R.drawable.podtlhalf);
			        txtTurn.setText(nextTurn);
				}
			       else{
			        btnPod[i].setClickable(true);
			        }
			    }
			    if(count == 4){
				
				txtTurn.setText("Click on Guess!");
				btnPlay.setClickable(true);
				count = 0;
				
			    }
			}
		    });
	    }
	    });
	}//end upper for
	for(int i=0;i<4;i++) 
	    btnPod[i].setText("");
	
    	
    }
    
    public void setRole(String role, String player){
	
    	if(player[0].equals("MANTRI")){
	    
	    player_role[3] = "MANTRI";
	}
	if(player[0].equals("RAJA")){
	    
	    player_role[3] = "RAJA";
	}
	if(player[0].equals("SIPAHI")){
	    
	    player_role[3] = "SIPAHI";
	}
	if(player[0].equals("CHOR")){
	    
	    player_role[3] = "CHOR";
	}
    	
    	
    } 
    
    void shuffleArray(String[] solutionArray)
    {
    	Random rnd = new Random();
    	for (int i = solutionArray.length - 1; i >= 0; i--)
	    {
		int index = rnd.nextInt(i + 1);
		
		String a = solutionArray[index];
		solutionArray[index] = solutionArray[i];
		solutionArray[i] = a;
	    }
    }
    
    static void updateScore(){
	
    	Log.v("AkhandBakar", "##########"+ guess);
	for(int q=0;q<4;q++)
    	if(player_role[q].equals("MANTRI"))
	    {
    		Log.v("AkhandBakar", "##########Mantri"+ player_name[q]);
		if(guess)
		    {
			i = i+80;
			pScope[0]=i;
			txtTurn.setText(player_name[l]+" is right!");
			for(int p=0;p<4;p++){
			    btnPod[p].setText(player[p]);
			    btnPod[p].setBackgroundResource(R.drawable.podopen);
			}
			
			if(player_role[0].equals("CHOR"))
			    {
    			pScope[0]=j;
    			if(player_role[2].equals("RAJA")){
			    
			    k = k+100;
			    l = l+50;
    				pScope[2]=k;
    				pScope[3]=l;
    			}else{
			    
			    l = l+100;
			    k = k+50;
			    pScope[3]=l;
			    pScope[2]=k;
    			}
			    }
			if(player_role[2].equals("CHOR"))
			    {
				
				pScope[2]=k;
				
				
				if(player_role[1].equals("RAJA")){
				    
				    j = j+100;
				    l = l+50;
				    pScope[1]=j;
				    pScope[3]=l;
				}else{
				    
				    l = l+100;
				    j = j+50;
				    pScope[3]=l;
				    pScope[1]=j;
				}
			    }
			if(player4_role.equals("CHOR"))
			    {
				
				pScope[3]=l;
				
				if(player_role[2].equals("RAJA")){
				    
				    k = k+100;
				    j = j+50;
				    pScope[1]=j;
				    pScope[2]=k;
				}else{
				    
				    j = j+100;
				    k = k+50;
				    pScope[2]=k;
				    pScope[1]=j;
				}
			    }
		    }
		else
		    {
			i=i-80;
			p1Scope = i;
			txtTurn.setText(player_name[q]+" is wrong!");
			for(int p=0;p<4;p++){
			    btnPod[p].setText(player[p]);
			    btnPod[p].setBackgroundResource(R.drawable.podopen);	
			}

			if(player_role[1].equals("CHOR"))
			    {
				j = j+25;
				pScope[1]=j;
				if(player_role[2].equals("RAJA")){
				    
				    k = k+100;
				    l = l+50;
				    pScope[2]=k;
				    pScope[3]=l;
				}else{
				    
				    l = l+100;
				    k = k+50;
				    pScope[3]=l;
				    pScope[2]=k;
				}
			    }
			if(player_role[2].equals("CHOR"))
			    {
				k=k+25;
				pScope[2]=k;
				
				
				if(player_role[1].equals("RAJA")){
				    
				    j = j+100;
				    l = l+50;
				    pScope[1]=j;
				    pScope[3]=l;
				}else{
				    
				    l = l+100;
				    j = j+50;
				    pScope[3]=l;
				    pScope[1]=j;
				}
			    }
			if(player_role[3].equals("CHOR"))
			    {
				l=l+25;
				pScope[3]=l;
				
				if(player_role[2].equals("RAJA")){
				    
				    k = k+100;
				    j = j+50;
				    pScope[1]=j;
				    pScope[2]=k;
				}else{
				    
				    j = j+100;
				    k = k+50;
				    pScope[2]=k;
				    pScope[1]=j;
				}
			}
		    }
		
	    }
	
		    }
		
	    }
	Log.v("AkhandBakar", "##########Score "+ i);

	
	txtPlayer[0].setText("1."+ player_name[0] + " [" + i + "]");	
        Log.v("AkhandBakar", player[0] + " [" + i + "]");

    	
	for(int p=1;p<4;p++){
	txtPlayer[p].setText((p+1)+"." + player_name[p]+ " [" + j + "]");
	
	Log.v("AkhandBakar", player[p] + " [" + pscore[p] + "]");
	}

    }
}
