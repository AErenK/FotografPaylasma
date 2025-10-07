package com.example.fotografpaylasma.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.fotografpaylasma.R
import com.example.fotografpaylasma.databinding.FragmentProfilBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kullanıcı bilgilerini yükle
        kullaniciBilgileriniYukle()

        // Button click listener'ları
        binding.duzenleButton.setOnClickListener { profilDuzenle() }
        binding.cikisButton.setOnClickListener { cikisYap() }
        binding.geriButton.setOnClickListener { geriDon() }
        binding.menuButton.setOnClickListener { anaMenuTiklandi(it) }
        binding.floatingActionButton.setOnClickListener { yuklemeTiklandi(it) }
    }

    private fun kullaniciBilgileriniYukle() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            binding.emailText.text = currentUser.email ?: "Email bulunamadı"
            binding.kayitTarihiText.text = "Kayıt Tarihi: ${currentUser.metadata?.creationTimestamp?.let {
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))
            } ?: "Bilinmiyor"}"

            // Profil resmi için varsayılan avatar
            binding.profilResmi.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }

    private fun profilDuzenle() {
        Toast.makeText(requireContext(), "Profil düzenleme özelliği yakında...", Toast.LENGTH_SHORT).show()
    }

    private fun cikisYap() {
        auth.signOut()
        val action = ProfilFragmentDirections.actionProfilFragmentToKullaniciFragment()
        Navigation.findNavController(requireView()).navigate(action)
        Toast.makeText(requireContext(), "Çıkış yapıldı", Toast.LENGTH_SHORT).show()

    }

    private fun geriDon() {
        // Geri butonu - önceki sayfaya dön
            requireActivity().onBackPressed()
    }

    fun anaMenuTiklandi(view: View) {
        val action = ProfilFragmentDirections.actionProfilFragmentToFeedFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    fun yuklemeTiklandi(view: View) {
        val action = ProfilFragmentDirections.actionProfilFragmentToYuklemeFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}