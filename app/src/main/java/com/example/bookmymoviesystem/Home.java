package com.example.bookmymoviesystem;

import android.graphics.Outline;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookmymoviesystem.R;

public class Home extends Fragment {

    private HorizontalScrollView horizontalScrollView;
    private LinearLayout imageContainerLayout;
    private Handler scrollHandler;
    private Runnable scrollRunnable;
    private int currentImageIndex = 0;
    private final long SCROLL_DELAY = 5000; // 5 seconds in milliseconds

    // Fragment initialization parameters
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views here, after the layout has been inflated
        horizontalScrollView = view.findViewById(R.id.horizontal_scroll_view);
        imageContainerLayout = view.findViewById(R.id.image_container_layout);

        // Ensure views are found before proceeding
        if (horizontalScrollView == null || imageContainerLayout == null) {
            // Handle the case where views are not found, perhaps log an error
            // or throw an exception, as this indicates a layout issue.
            return;
        }

        scrollHandler = new Handler(Looper.getMainLooper());
        scrollRunnable = new Runnable() {
            @Override
            public void run() {
                if (imageContainerLayout != null && imageContainerLayout.getChildCount() > 0) {
                    currentImageIndex = (currentImageIndex + 1) % imageContainerLayout.getChildCount();
                    View nextImage = imageContainerLayout.getChildAt(currentImageIndex);

                    if (nextImage != null) {
                        int scrollTo = nextImage.getLeft();
                        horizontalScrollView.smoothScrollTo(scrollTo, 0);
                    }
                }
                if (scrollHandler != null) { // Check if handler is still valid
                    scrollHandler.postDelayed(this, SCROLL_DELAY);
                }
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        startAutoScroll();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopAutoScroll();
    }

    private void startAutoScroll() {
        if (imageContainerLayout != null && imageContainerLayout.getChildCount() > 0 &&
                scrollHandler != null && scrollRunnable != null) {
            scrollHandler.removeCallbacks(scrollRunnable);
            scrollHandler.postDelayed(scrollRunnable, SCROLL_DELAY);
        }
    }

    private void stopAutoScroll() {
        if (scrollHandler != null && scrollRunnable != null) {
            scrollHandler.removeCallbacks(scrollRunnable);
        }
    }



    // You had a custom setContentView method, which is not standard for Fragments.
    // Layout inflation is handled by onCreateView. If you need to perform actions
    // that setContentView would do in an Activity, do them in onViewCreated or onCreateView.
    // public void setContentView(int home) { }

}