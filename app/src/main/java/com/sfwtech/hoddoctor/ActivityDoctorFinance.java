package com.sfwtech.hoddoctor;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sfwtech.hoddoctor.fragments.FragmentADFAddAccount;
import com.sfwtech.hoddoctor.fragments.FragmentADFDashboard;
import com.sfwtech.hoddoctor.fragments.dialog.DialogFragmentFieldsUpdate;

/**
 * Created by SFWorx Technologies (LLP) on 10/20/2015
 * test git.
 **/
public class ActivityDoctorFinance extends AppCompatActivity implements
        FragmentADFDashboard.FragmentADFDashboardIFace,
        DialogFragmentFieldsUpdate.DialogFragmentFieldsUpdateIFace {

    FragmentADFDashboard fragmentADFDashboard;
    FragmentADFAddAccount fragmentADFAddAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_finance);

        if (findViewById(R.id.adf_fl_root) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            fragmentADFDashboard = new FragmentADFDashboard();

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.adf_fl_root, fragmentADFDashboard).commit();
        }
    }

    @Override
    public void addBankAccount() {
        fragmentADFAddAccount = new FragmentADFAddAccount();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                android.R.anim.fade_in, android.R.anim.fade_out);
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.adf_fl_root, fragmentADFAddAccount, "fragmentADFAddAccount");
        transaction.addToBackStack("fragmentADFAddAccount");
        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onDialogFragmentFieldsUpdateDismissed(boolean pinWasUpdated) {
        getSupportFragmentManager().popBackStack();
    }
}
