package vazquez.ivan.mydigimind.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vazquez.ivan.mydigimind.Recordatorio

class SharedViewModel : ViewModel() {
    companion object {
        private val _recordatorios = MutableLiveData<ArrayList<Recordatorio>>().apply {
            value = arrayListOf(
                Recordatorio("Tarea", arrayListOf("Monday", "Friday"), "12:34 pm"),
                Recordatorio("Trabajo", arrayListOf("Monday", "Friday"), "12:34 pm"),
                Recordatorio("Juego", arrayListOf("Monday", "Friday"), "12:34 pm"),
                Recordatorio("Reunion", arrayListOf("Monday", "Friday"), "12:34 pm"),
                Recordatorio("Familia", arrayListOf("Monday", "Friday"), "12:34 pm"),
                Recordatorio("Junta", arrayListOf("Monday", "Friday"), "12:34 pm")
            )
        }
        val recordatorios: LiveData<ArrayList<Recordatorio>> = _recordatorios

        fun addRecordatorio(recordatorio: Recordatorio) {
            val currentList = _recordatorios.value ?: ArrayList()
            currentList.add(recordatorio)
            _recordatorios.value = currentList
        }
    }
}
