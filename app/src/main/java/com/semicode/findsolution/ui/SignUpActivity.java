package com.semicode.findsolution.ui;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.semicode.findsolution.R;

import com.semicode.findsolution.databinding.ActivitySignupBinding;
import com.semicode.findsolution.databinding.DialogSelectImageBinding;
import com.semicode.findsolution.mvp.activitySginUp.ActivitySignUpPresenter;
import com.semicode.findsolution.mvp.activitySginUp.ActivitySignUpView;
import com.semicode.findsolution.share.Common;
import com.semicode.findsolution.share.HelperMethod;
import com.semicode.findsolution.ui.homeActivity.HomeActivity;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, ActivitySignUpView {
    private ActivitySignupBinding binding;
    private ActivitySignUpPresenter presenter;
    private AlertDialog dialog;
    private final int READ_REQ = 1, CAMERA_REQ = 2;

    private final String READ_PERM = Manifest.permission.READ_EXTERNAL_STORAGE;
    private final String write_permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private final String camera_permission = Manifest.permission.CAMERA;
    private Uri uri;
    String phoneCode, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        intil();
    }

    private void intil() {
        getDataFromIntent();
        binding.activityAddNameBtnConfirm.setOnClickListener(this);
        binding.signUpIvPhoto.setOnClickListener(this);
        presenter = new ActivitySignUpPresenter(this, this, uri);
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            phoneNumber = intent.getStringExtra("PHONE_NUMBER");
            phoneCode = intent.getStringExtra("PHONE_CODE");

        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_add_name_btn_confirm:
                String name = binding.signUpEtName.getText().toString();
//                String imagePath = uri.getPath();
//                createImageDialog();
                if (TextUtils.isEmpty(name)) {
                    HelperMethod.makeTextToast(getApplicationContext(), "jjj" + " ");

                } else {
//                    presenter.signUp(imagePath, phoneCode, phoneNumber, name);
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.sign_up_iv_photo:
                createImageDialog();
                HelperMethod.makeTextToast(this, "choses image");
                break;
        }
    }

    private void createImageDialog() {
        dialog = new AlertDialog.Builder(this)
                .create();

        DialogSelectImageBinding binding = DataBindingUtil.inflate(LayoutInflater.from(this)
                , R.layout.dialog_select_image, null, false);
        binding.btnCamera.setOnClickListener(view -> {
            dialog.dismiss();
            checkCameraPermission();
        });
        binding.btnGallery.setOnClickListener(view -> {
            dialog.dismiss();
            checkReadPermission();
        });
        binding.btnCancel.setOnClickListener(v -> dialog.dismiss()

        );
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_congratulation_animation;
        dialog.setCanceledOnTouchOutside(false);
        dialog.setView(binding.getRoot());
        dialog.show();
    }

    private void checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, write_permission) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, camera_permission) == PackageManager.PERMISSION_GRANTED
        ) {
            SelectImage(CAMERA_REQ);
            HelperMethod.makeTextToast(this, "permission done");
        } else {
            HelperMethod.makeTextToast(this, "permission not done ");
            ActivityCompat.requestPermissions(this, new String[]{camera_permission, write_permission}, CAMERA_REQ);
        }
    }

    public void checkReadPermission() {
        if (ActivityCompat.checkSelfPermission(this, READ_PERM) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{READ_PERM}, READ_REQ);
        } else {
            SelectImage(READ_REQ);
        }
    }

    private Uri getUriFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        return Uri.parse(MediaStore.Images.Media.insertImage(this.getContentResolver(), bitmap, "", ""));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == READ_REQ && resultCode == Activity.RESULT_OK && data != null) {
            HelperMethod.makeTextToast(this, "on results");
            uri = data.getData();
            binding.signUpIvIcon.setVisibility(View.GONE);
            File file = new File(Common.getImagePath(this, uri));
            Picasso.get().load(file).fit().into(binding.signUpIvPhoto);
//            signUpModel.setLicenseImage(uri.toString());
//            binding.setModel(signUpModel);

        } else if (requestCode == CAMERA_REQ && resultCode == Activity.RESULT_OK && data != null) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            uri = getUriFromBitmap(bitmap);
            binding.signUpIvIcon.setVisibility(View.GONE);

            if (uri != null) {

                String path = Common.getImagePath(this, uri);
                if (path != null) {
                    Picasso.get().load(new File(path)).fit().into(binding.signUpIvPhoto);

                } else {
                    Picasso.get().load(uri).fit().into(binding.signUpIvPhoto);

                }
            }


        }
    }

    private void SelectImage(int req) {

        Intent intent = new Intent();

        if (req == READ_REQ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            } else {
                intent.setAction(Intent.ACTION_GET_CONTENT);

            }

            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setType("image/*");
            startActivityForResult(intent, req);

        } else if (req == CAMERA_REQ) {
            try {
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, req);
            } catch (SecurityException e) {
                Toast.makeText(this, R.string.perm_image_denied, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, R.string.perm_image_denied, Toast.LENGTH_SHORT).show();

            }


        }
    }


    @Override
    public void onSignUpDone(String imageUrl) {
        HelperMethod.makeTextToast(this, imageUrl);
    }

    @Override
    public void onSignUpNotDone(String message) {
        HelperMethod.makeTextToast(this, message);
    }
}