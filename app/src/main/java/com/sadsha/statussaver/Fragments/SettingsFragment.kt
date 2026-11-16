package com.sadsha.statussaver.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.sadsha.statussaver.R
import com.sadsha.statussaver.databinding.FragmentSettingsBinding
import com.sadsha.statussaver.Models.SettingsModel
import com.sadsha.statussaver.Adapters.SettingsAdapter


class SettingsFragment : Fragment() {

    private val binding by lazy {
        FragmentSettingsBinding.inflate(layoutInflater)
    }
    private val list = ArrayList<SettingsModel>()
    private val adapter by lazy {
        SettingsAdapter(list, requireActivity())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            settingsRecyclerView.adapter = adapter
            list.add(
                SettingsModel(
                    title = "How to use",
                    desc = "Know how to download statuses"
                )
            )
            list.add(
                SettingsModel(
                    title = "Save in Folder",
                    desc = "/internalstorage/Documents/${getString(R.string.app_name)}"
                )
            )
            list.add(
                SettingsModel(
                    title = "Disclaimer",
                    desc = "Read Our Disclaimer"
                )
            )
            list.add(
                SettingsModel(
                    title = "Privacy Policy",
                    desc = "Read Our Terms & Conditions"
                )
            )
            list.add(
                SettingsModel(
                    title = "Share",
                    desc = "Sharing is caring"
                )
            )
            list.add(
                SettingsModel(
                    title = "Rate Us",
                    desc = "Please support our work by rating on PlayStore"
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    showExitConfirmationDialog()
                }
            })

        return view
    }

    private fun showExitConfirmationDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle("Exit App")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { dialog, _ ->
                // Exit the app
                requireActivity().finish()
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ ->
                // Dismiss the dialog and do nothing
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
    }
}