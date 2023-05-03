package baodng.example.soundwave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RawRes
import baodng.example.soundwave.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoBinding


    private lateinit var audioPlayer: AudioPlayerUtil
    private lateinit var audioPlayer2: AudioPlayerUtil
    private lateinit var audioPlayer3: AudioPlayerUtil

    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        audioPlayer = AudioPlayerUtil()
        audioPlayer2 = AudioPlayerUtil()
        audioPlayer3 = AudioPlayerUtil()
    }

    /**
     *
     */
    override fun onStart() {
        super.onStart()
        startPlayingAudio(R.raw.coffin_dance)
    }

    /**
     *
     */
    override fun onStop() {
        super.onStop()
        stopPlayingAudio();
    }

    private fun startPlayingAudio(@RawRes resId: Int) {
        audioPlayer.play(this, resId) {
        }
        audioPlayer.getAudioSessionId()
            ?.also {
                binding.barVisualizerPanel.setAudioSessionId(it)
            }

        audioPlayer2.play(this, resId) {
        }
        audioPlayer2.getAudioSessionId()
            ?.also {
                binding.waveVisualizerPanel .setAudioSessionId(it)
            }

        audioPlayer3.play(this, resId) {
        }
        audioPlayer3.getAudioSessionId()
            ?.also {
                binding.mixedBarVisualizerPanel.setAudioSessionId(it)
            }
    }

    private fun stopPlayingAudio() {
        audioPlayer.stop();
        binding.barVisualizerPanel.release()

        audioPlayer2.stop();
        binding.mixedBarVisualizerPanel.release()

        audioPlayer3.stop();
        binding.waveVisualizerPanel.release()
    }
}