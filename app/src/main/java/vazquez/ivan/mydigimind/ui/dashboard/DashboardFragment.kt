package vazquez.ivan.mydigimind.ui.dashboard

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import vazquez.ivan.mydigimind.Recordatorio
import vazquez.ivan.mydigimind.databinding.FragmentDashboardBinding
import vazquez.ivan.mydigimind.ui.home.SharedViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnDone.setOnClickListener {
            val titulo = binding.laCosa.text.toString()
            val dias = arrayListOf<String>().apply {
                if (binding.checkMon.isChecked) add("Monday")
                if (binding.checkTue.isChecked) add("Tuesday")
                if (binding.checkWed.isChecked) add("Wednesday")
                if (binding.checkThu.isChecked) add("Thursday")
                if (binding.checkFri.isChecked) add("Friday")
                if (binding.checkSat.isChecked) add("Saturday")
                if (binding.checkSun.isChecked) add("Sunday")
            }
            val hora = "${binding.tiempo.hour}:${binding.tiempo.minute} ${if (binding.tiempo.hour < 12) "am" else "pm"}"


            val recordatorio = Recordatorio(titulo, dias, hora)
            SharedViewModel.addRecordatorio(recordatorio)

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
