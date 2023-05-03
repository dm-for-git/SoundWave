package baodng.example.soundwave

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import baodng.example.soundwave.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val PERMISSIONS_REQUEST_CODE = 4837
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.startDemoButton.setOnClickListener {
            if (checkAudioPermission()) {
                startActivity(Intent(this@MainActivity, DemoActivity::class.java))
            }
            else {
                requestAudioPermission()
            }
        }
    }

    private fun checkAudioPermission(): Boolean =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED


    private fun requestAudioPermission() {
        ActivityCompat.requestPermissions(this, Array(1) {android.Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_CODE)
    }
}