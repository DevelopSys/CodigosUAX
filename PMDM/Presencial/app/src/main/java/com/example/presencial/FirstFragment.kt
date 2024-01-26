package com.example.presencial

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.presencial.databinding.FragmentFirstBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            /*val bundle = Bundle();
            bundle.putInt("nombre",2)
            bundle.putInt("nombre1",2)
            bundle.putInt("nombre2",2)
            bundle.putInt("nombre3",2)*/
            auth.createUserWithEmailAndPassword("bmartin@gmail.com","Prueba1234_")
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        Log.v("autenticacion","usuario creado con exito")
                    } else {
                        Log.v("autenticacion","fallo en el registro")
                    }
                }
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
        }
        binding.buttonSecond.setOnClickListener {
            auth.signInWithEmailAndPassword("bmartin@gmail.com","Prueba1234_")
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        findNavController()
                            .navigate(R.id.action_FirstFragment_to_SecondFragment)
                    } else {
                        Log.v("autenticacion","fallo de credenciales")

                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}