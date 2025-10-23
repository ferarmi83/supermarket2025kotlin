package bo.edu.uajms.sistemasbermejo.aramayofernando.surmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class FragmentLogin : Fragment() {
    //Variables de los controles
    private lateinit var ETXUser: EditText
    private lateinit var ETXPassword : EditText
    private lateinit var TXVPasswordRecover: TextView
    private lateinit var BTNLogin : Button
    private lateinit var BTNRegister : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureEvents()
    }

    private fun initializeViews(view: View) {
        ETXUser = view.findViewById(R.id.ETXUser)
        ETXPassword = view.findViewById(R.id.ETXPassword)
        TXVPasswordRecover = view.findViewById(R.id.TXVPasswordRecover)
        BTNLogin = view.findViewById(R.id.BTNLogin)
        BTNRegister = view.findViewById(R.id.BTNRegister)
    }

    private fun configureEvents() {
        TXVPasswordRecover.setOnClickListener(){

        }
        BTNLogin.setOnClickListener(){
            initSession()
        }
        BTNRegister.setOnClickListener(){

        }
    }

    private fun initSession() {
        var us = ETXUser.text.toString()
        var pw = ETXPassword.text.toString()
        if (!validateCredentials(us,pw))
        {
            Toast.makeText(context,R.string.validationError, Toast.LENGTH_SHORT)
        }
        else if (verifyCredentials(us,pw))
        {
            Toast.makeText(context,R.string.welcome, Toast.LENGTH_SHORT)
        }
        else
        {
            Toast.makeText(context,R.string.wrongUserOrPassword, Toast.LENGTH_SHORT)
        }
    }

    private fun validateCredentials(us:String,pw:String): Boolean{
        var isCorrect= true
        if (us.isEmpty())
        {
            ETXUser.error = R.string.userError.toString()
            isCorrect = false
        }
        else
        {
            ETXUser.error = null
        }
        if (pw.isEmpty())
        {
            ETXPassword.error = R.string.PasswordError.toString()
            isCorrect = false
        }
        else
        {
            ETXPassword.error = null
        }
        return isCorrect
    }
    private fun verifyCredentials(us:String,pw:String): Boolean {
        return us=="admin" && pw=="123456"
    }
}