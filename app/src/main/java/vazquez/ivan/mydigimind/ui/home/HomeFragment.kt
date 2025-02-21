package vazquez.ivan.mydigimind.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vazquez.ivan.mydigimind.Recordatorio
import vazquez.ivan.mydigimind.databinding.FragmentHomeBinding
import vazquez.ivan.mydigimind.R

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val gridView: GridView = binding.grid
        SharedViewModel.recordatorios.observe(viewLifecycleOwner) { recordatorios ->
            val adapter = RecordatorioAdapter(requireContext(), recordatorios)
            gridView.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private inner class RecordatorioAdapter(private val context: Context, private val recordatorios: List<Recordatorio>) : BaseAdapter() {

        override fun getCount(): Int {
            return recordatorios.size
        }

        override fun getItem(position: Int): Any {
            return recordatorios[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.recordatorio, parent, false)

            val titulo: TextView = view.findViewById(R.id.titulo)
            val dia: TextView = view.findViewById(R.id.dia)
            val hora: TextView = view.findViewById(R.id.hora)

            val recordatorio = recordatorios[position]
            titulo.text = recordatorio.titulo
            dia.text = recordatorio.dias.joinToString(", ")
            hora.text = recordatorio.hora

            return view
        }
    }
}
