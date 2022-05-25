package com.example.e_kengash.main.fragments.more.main

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.e_kengash.R
import com.example.e_kengash.databinding.AlertDialogExitBinding
import com.example.e_kengash.databinding.AlertDialogSignUpBinding
import com.example.e_kengash.databinding.FragmentMoreBinding
import com.example.e_kengash.main.activity.login.main.LoginActivity
import com.example.e_kengash.main.activity.mainActivity.MainActivity
import com.example.e_kengash.main.activity.moreInActivity.aboutProgramma.main.AboutProgrammaActivity
import com.example.e_kengash.main.activity.moreInActivity.acceptance.main.AcceptanceActivity
import com.example.e_kengash.main.activity.moreInActivity.activities.main.ActivitiesActivity
import com.example.e_kengash.main.activity.moreInActivity.article.ArticleActivity
import com.example.e_kengash.main.activity.moreInActivity.commission.main.CommissionActivity
import com.example.e_kengash.main.activity.moreInActivity.council.main.CouncilActivity
import com.example.e_kengash.main.activity.moreInActivity.discussion.main.DiscussionActivity
import com.example.e_kengash.main.activity.moreInActivity.document.main.DocumentActivity
import com.example.e_kengash.main.activity.moreInActivity.faq.main.FaqActivity
import com.example.e_kengash.main.activity.moreInActivity.profil.main.ProfilActivity
import com.example.e_kengash.main.fragments.baseFragment.BaseFragment
import com.example.e_kengash.main.activity.moreInActivity.secretariat.mian.SecretariatActivity
import com.example.e_kengash.main.activity.moreInActivity.senatorAndDeputat.main.SenatorAndDeputat
import com.example.e_kengash.main.activity.moreInActivity.settings.main.SettingsActivity
import com.example.e_kengash.main.activity.moreInActivity.youth.main.YouthActivity
import com.example.e_kengash.repetitive.D

class More : BaseFragment<FragmentMoreBinding>(FragmentMoreBinding::inflate) {
    override fun onViewCreate() {
        binding.apply {
            council.setOnClickListener {
                startActivity(Intent(requireContext(), CouncilActivity::class.java))
            }
            secretariat.setOnClickListener {
                startActivity(Intent(requireContext(), SecretariatActivity::class.java))
            }
            articles.setOnClickListener {
                startActivity(Intent(requireContext(), ArticleActivity::class.java))
            }
            senator.setOnClickListener {
                startActivity(Intent(requireContext(), SenatorAndDeputat::class.java))
            }
            youth.setOnClickListener {
                startActivity(Intent(requireContext(), YouthActivity::class.java))
            }
            discussion.setOnClickListener {
                startActivity(Intent(requireContext(), DiscussionActivity::class.java))
            }
            activitys.setOnClickListener {
                startActivity(Intent(requireContext(), ActivitiesActivity::class.java))
            }
            commission.setOnClickListener {
                startActivity(Intent(requireContext(), CommissionActivity::class.java))
            }
            acceptance.setOnClickListener {
                when(sharePereferenseHelper.getAccessToken()=="empty")
                {
                    true->{
                        signUp()
                    }
                    else->{
                        startActivity(Intent(requireContext(), AcceptanceActivity::class.java))
                    }
                }

            }
            profil.setOnClickListener {
                when(sharePereferenseHelper.getAccessToken()=="empty")
                {
                    true->{
                        signUp()
                    }
                    else->{
                        startActivity(Intent(requireContext(), ProfilActivity::class.java))
                    }
                }

            }
            document.setOnClickListener {
                startActivity(Intent(requireContext(), DocumentActivity::class.java))
            }
            faq.setOnClickListener {
                startActivity(Intent(requireContext(), FaqActivity::class.java))
            }
            aboutProgram.setOnClickListener {
                startActivity(Intent(requireContext(), AboutProgrammaActivity::class.java))
            }
            setting.setOnClickListener {
                startActivity(Intent(requireContext(), SettingsActivity::class.java))
            }
            exit.setOnClickListener {
                exitDialog()

            }
        }
    }

    private fun signUp() {
        val alertDialog: AlertDialog.Builder =
            AlertDialog.Builder(requireContext(), R.style.Style_Dialog_Rounded_Corner)
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.alert_dialog_sign_up, null)
        val dialogBind = AlertDialogSignUpBinding.bind(view)
        dialogBind.done.setOnClickListener {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
        }
        alertDialog.apply {
            setView(view)
            show()
        }
    }

    private fun exitDialog() {
        val alertDialog = AlertDialog.Builder(requireContext(),R.style.Style_Dialog_Rounded_Corner).create()
        val view = LinearLayout.inflate(requireContext(), R.layout.alert_dialog_exit,null)
        val dialogBind = AlertDialogExitBinding.bind(view)
        alertDialog.apply {
            setView(view)
            show()
        }
        dialogBind.exitNo.setOnClickListener {
            D("keliiii")
            alertDialog.dismiss()
        }
        dialogBind.exitYes.setOnClickListener {
            sharePereferenseHelper.setAccessToken("empty")
            startActivity(Intent(requireContext(),MainActivity::class.java))
            activity?.finishAffinity()
        }
    }


}