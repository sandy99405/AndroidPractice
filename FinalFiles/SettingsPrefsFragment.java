private void initSuperPrivacyPrefsCallbacks(){
     final Preference pref = getPreference(getString(R.string.pref_super_privacy));

     final boolean isSuperPrivacyEnabled = Config.isSuperPrivacyEnabled();
     ((TwoStatePreference) pref).setChecked(isSuperPrivacyEnabled);
     pref.setOnPreferenceChangeListener(
        (preference,newValue) ->
        {
            boolean newVal = (Boolean) newVal;
            if(isSuperPrivacyEnabled != newVal){
                 Config.setSuperPrivacyEnabled(newVal);
                 Utils.(newVal,requireActivity());
            }
            return true;
        });
}