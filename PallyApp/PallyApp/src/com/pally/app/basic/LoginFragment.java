package com.pally.app.basic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.pally.app.PallyContatns;
import com.pally.app.R;
import com.pally.app.home.HomeActivity;
import com.pally.internetconnection.ConnectionDetector;

public class LoginFragment extends Fragment implements OnClickListener {

	private Button mDoLoginButton,mDoFacebookLogin;
	private TextView mForgetPassword;
	Boolean isInternetPresent = false;
	ConnectionDetector cd;	
	private static String APP_ID = "974923809204791"; 
	private Facebook facebook;
	String facebookloginid,facebookemail,facebookname,facebookbirthday="";
	static AsyncFacebookRunner mAsyncRunner;
	private SharedPreferences mPrefs;
	SharedPreferences sharedpreferences;
	Editor editor;
	public static final String name = "nameKey"; 
	public static final String pass = "passwordKey"; 
	static Context context;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String LoginPreferences = "loginpref" ;
	SharedPreferences sharepref;
	SharedPreferences.Editor editorforlogin;
	ProgressDialog pDialogforfacebookdata;
	public static int logoutflag = -1;
	public static final String login_status = "loginstatus";

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_login, container, false);

	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mDoLoginButton = (Button) view.findViewById(R.id.login);
		mDoLoginButton.setOnClickListener(this);
		
		mDoFacebookLogin = (Button) view.findViewById(R.id.facebook);
		mDoFacebookLogin.setOnClickListener(this);

		mForgetPassword = (TextView) view
				.findViewById(R.id.forgot_password);
		mForgetPassword.setOnClickListener(this);
		
		cd= new ConnectionDetector(context);

	}

	@Override
	public void onClick(View v) {
		if (v == mDoLoginButton) {
			startActivity(new Intent(getActivity(), HomeActivity.class));
			getActivity().finish();
		}
		if (v == mForgetPassword) {
			((BaseActivity) getActivity()).addNewFragment(R.id.basic_container,
					new ForgetPasswordFragment(), true,
					PallyContatns.FORGET_PASSWORD_FRAGMENT);
		}
		
		if (v == mDoFacebookLogin) {
			
			facebook = new Facebook(APP_ID);
			mAsyncRunner = new AsyncFacebookRunner(facebook);
			loginToFacebook();

			
		}


	}

	private void loginToFacebook() {
		
		
		mPrefs = getActivity().getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
		String access_token = mPrefs.getString("access_token", null);

		System.out.println("Access token-->"+access_token);

		long expires = mPrefs.getLong("access_expires", 0);
		//	 
		if (access_token != null) {
			facebook.setAccessToken(access_token);
			System.out.println("FaceBook Access Token -->"+access_token);
		}
		//	 
		if (expires != 0) {
			facebook.setAccessExpires(expires);

		}

		if (!facebook.isSessionValid()) {
			Activity activity= (Activity) getActivity();
			
			
			facebook.authorize(activity, new String[] {"user_birthday","email","read_stream","offline_access","publish_checkins", "publish_stream","friends_birthday","publish_actions","public_profile","user_friends","user_photos","manage_pages","status_update"
			},Facebook.FORCE_DIALOG_AUTH,
			new DialogListener() {

				@Override
				public void onComplete(Bundle values) {
					// TODO Auto-generated method stub
					//ProgressDialog pDialog;
					SharedPreferences.Editor editor = mPrefs.edit();
					editor.putString("access_token",
							facebook.getAccessToken());
					
					
					System.out.println("DialogSignUp.loginToFacebook()"+facebook.getAccessToken());
					editor.putLong("access_expires",
							facebook.getAccessExpires());
					editor.commit();
//					dialog.dismiss();

					getProfileInformation();
					pDialogforfacebookdata = new ProgressDialog((Activity)getActivity());
					pDialogforfacebookdata.setMessage("Signing via Facebook");

					pDialogforfacebookdata.setCancelable(false);

					pDialogforfacebookdata.show();



					logoutflag=1;
					sharepref=getActivity().getSharedPreferences(LoginPreferences, 0);
					editorforlogin= sharepref.edit();
					editorforlogin.putInt(login_status, 1);
					editorforlogin.commit();
					//					Toast.makeText(context,"Login with simple"+String.valueOf(sharepref.getInt("loginstatus", 4)), Toast.LENGTH_SHORT).show();

					new Handler().postDelayed(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							new SendFacebookData().execute();
						}
					}, 15000);

				}

				@Override
				public void onFacebookError(FacebookError e) {
					// TODO Auto-generated method stub
					Toast.makeText(getActivity(), "onFacebookError", Toast.LENGTH_SHORT).show();

				}

				@Override
				public void onError(DialogError e) {
					// TODO Auto-generated method stub
					isInternetPresent=cd.isConnectingToInternet();
					if(isInternetPresent==false){

					Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_SHORT).show();
					}

				}

				@Override
				public void onCancel() {
					// TODO Auto-generated method stub

					//					showtoast("onCancel");
				}

			});

		}
		
		
	}

	public void getProfileInformation() {
		
		mAsyncRunner.request("me", new RequestListener() {
		
			@Override
			public void onComplete(String response, Object state) {
				Log.d("Profile", response);
				System.out
						.println("DialogSignUp.getProfileInformation().new RequestListener() {...}.onComplete()" +response);
				String json = response;

				try {
					JSONObject profile = new JSONObject(json);
					// getting name of the user
					facebookname = profile.getString("name");
					// getting email of the user
					facebookemail = profile.getString("email");
					facebookloginid=profile.getString("id");
					if(!(profile.isNull("birthday")))
						facebookbirthday=profile.getString("birthday");
					      
//					

					sharedpreferences=getActivity().getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
					editor = sharedpreferences.edit();

					System.out.println("Name from facebook-->"+ facebookname );
					System.out.println("Email facebook-->"+ facebookemail );
//					editor.putString(name, facebookemail);
					editor.putString("loginid",facebookloginid);
					
					
					editor.putString(pass,facebookname);
					editor.putString("name", facebookname);
					editor.putString("emailid",facebookemail);
					editor.putString("loginvia", "-- Login via Facebook Social Media");
					editor.commit();
					//						MyToastBottom.show(context, facebookname+" Login Successfully via Facebook", true);



					//	                editor.putString(name, profile.getString("name"));
					//      				 editor.putString(pass, password.getText().toString());
					//      				 editor.putString("loginid",profile.getString("id"));
					//      				 editor.putString("name",loginname);
					//      				 editor.putString("loginage",loginage);
					//      				 editor.putString("loginpincode",loginpincode);
					//      				 editor.putString("logincontact",logincontact);
					//      				 editor.putString("loginaddress",loginaddress);
					//      				 editor.putString("logintoken",logintoken);

					System.out.println("Name from facebook-->"+ facebookname );
					System.out.println("JSONObject of facebook ---> "+profile.toString() );

				} catch (JSONException e) {
					e.printStackTrace();
				}


			}

			@Override
			public void onIOException(IOException e, Object state) {
			}

			@Override
			public void onFileNotFoundException(FileNotFoundException e,
					Object state) {
			}

			@Override
			public void onMalformedURLException(MalformedURLException e,
					Object state) {
			}

			@Override
			public void onFacebookError(FacebookError e, Object state) {
			}
		});



	}
	
	
	class SendFacebookData extends AsyncTask<Void, Void, Void>{
		
//		int flag=0;
		int flag=1;

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
//			sharedpreferences=getActivity().getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
//			editor = sharedpreferences.edit();
//			List<NameValuePair> list = new ArrayList<NameValuePair>();
//			list.add(new BasicNameValuePair("facebookname",facebookname));
//			list.add(new BasicNameValuePair("facebookemail", facebookemail));
//			list.add(new BasicNameValuePair("facebookid", facebookloginid));
//			System.out
//					.println("DialogSignUp facebook id"+facebookloginid);
//			list.add(new BasicNameValuePair("gcmid", FirstPageActivityWithDrawer.regId));
//			
//			list.add(new BasicNameValuePair("dob", facebookbirthday));
//			list.add(new BasicNameValuePair("accesstoken", sharedpreferences.getString("access_token", "")));
//			ServiceHandler serviceHandler = new ServiceHandler();
//			System.out.println("Under DoInbackgroung senddataoffb----->");
//			System.out.println("Under SendFAcebook data Access Token----->"+sharedpreferences.getString("access_token", ""));
//			System.out.println("facebook name under Async -->"+facebookname+" /"+facebookemail+" /"+facebookloginid);
//
//			String response=serviceHandler.makeServiceCall(SecondActivity.url+"fblogin.php", ServiceHandler.POST, list);
//			if(response!=null){
//					
//				System.out.println("Responsefacebook"+response );
//				try {
//					JSONObject jsonObject = new JSONObject(response);
//					Boolean success=jsonObject.getBoolean("success");
//					System.out.println("Success-->"+success);
//					if(success)
//						flag=1;
//
//				} catch (JSONException e) {
//					// TODO Auto-gener ated catch block
//					e.printStackTrace();
//				}
//
//			}

			return null;
		}


		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			if (pDialogforfacebookdata.isShowing())
				pDialogforfacebookdata.dismiss();

			if(flag==1){
				Toast.makeText(getActivity(), "Login Success via Facebook", Toast.LENGTH_SHORT).show();
			}
			else
				Toast.makeText(getActivity(), "Problem with Login via facebook", Toast.LENGTH_SHORT).show();
		}
	
	}

}
