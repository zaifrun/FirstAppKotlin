package org.pondar.firstappkotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import org.pondar.firstappkotlin.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Notice the next lines - this sets up
            Viewbinding. The name of the binding class
            will be the same as the name of the XML file with "Binding" appended.
            So the xml file is name main_activity.xml, so the
            binding class will be named MainActivityBinding (the _ is stripped)
            ViewBinding is enabled in the build.gralde (app module file) with
            this command (as you can see in the file):
            buildFeatures {
                viewBinding true
                }
         */
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root  //This gets the root node.
        setContentView(view)  //This tells Android that UI will be this xml file

        setSupportActionBar(findViewById(R.id.toolbar))

        binding.fab.setOnClickListener {
            Snackbar.make(it, "Hello class from a snackbar", Snackbar.LENGTH_LONG).show()
            binding.includedContent.welcomeTextView.text = resources.getString(R.string.thank_you)
            //notice the notation above - with binding.includedContent.welcomeTextView - why is that?
            //(Hint: Look at the xml files...)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}