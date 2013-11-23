package android.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {


		 //Cr�ation d'un MenuInflater qui va permettre d'instancier un Menu XML en un objet Menu
        MenuInflater inflater = getMenuInflater();
        //Instanciation du menu XML sp�cifier en un objet Menu
        inflater.inflate(R.menu.main, menu);
 
        //Il n'est pas possible de modifier l'ic�ne d'ent�te du sous-menu via le fichier XML on le fait donc en JAVA
    	//menu.getItem(0).getSubMenu().setHeaderIcon(R.drawable.option_white);
 
        return true;
        
	}

	//M�thode qui se d�clenchera au clic sur un item
    public boolean onOptionsItemSelected(MenuItem item) {
       //On regarde quel item a �t� cliqu� gr�ce � son id et on d�clenche une action
       switch (item.getItemId()) {
          case R.id.option:
             Toast.makeText(MainActivity.this, "Option", Toast.LENGTH_SHORT).show();
             return true;
          case R.id.favoris:
              Toast.makeText(MainActivity.this, "Favoris", Toast.LENGTH_SHORT).show();
              return true;
          case R.id.stats:
              Toast.makeText(MainActivity.this, "Stats", Toast.LENGTH_SHORT).show();
              return true;
         case R.id.quitter:
             //Pour fermer l'application il suffit de faire finish()
             finish();
             return true;
       }
       return false;}
}
