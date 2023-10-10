SearchHistoryAdapter searchHistoryAdapter = new SearchHistoryAdapter();
ViewHolde res;
private void initSuperPrivacyPrefsCallbacks(){
     final Preference pref = getPreference(getString(R.string.pref_super_privacy));

     final boolean isSuperPrivacyEnabled = Config.isSuperPrivacyEnabled();
     ((TwoStatePreference) pref).setChecked(isSuperPrivacyEnabled);
     pref.setOnPreferenceChangeListener(
        (preference,newValue) ->
        {
            boolean newVal = (Boolean) newValue;
            if(isSuperPrivacyEnabled != newVal){
                 SearchRecents.clear();
                 searchHistoryAdapter.notifyDataSetChanged();
/*                  Config.setSuperPrivacyEnabled(newVal);
                 Utils.(newVal,requireActivity()); */
            }else{
                 res = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search_recent, viewGroup, false));
                 res.mText.setOnClickListener(new View.OnClickListener()
                 {
                    @Override
                    public void onClick(View v)
                    {
                      mSearchToolbarController.setQuery(res.mText.getText());
                    }
                  });  

                 or 

                  searchHistoryAdapter.getIsEnabled(Config.isSuperPrivacyEnabled);
                 
            }     
            return true;
        });
}
