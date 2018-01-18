package jayantb95.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jayantb95.recyclerview.adapter.MoviesAdapter;
import jayantb95.recyclerview.adapter.RecyclerTouchListener;
import jayantb95.recyclerview.dataModel.MovieModel;

public class MainActivity extends AppCompatActivity {
    private List<MovieModel> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setupRecyclerview();
        listener();
    }

    private void initialize() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void setupRecyclerview() {
        mAdapter = new MoviesAdapter(movieList);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        loadData();
    }

    private void listener() {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MovieModel movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                MovieModel movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is being held!", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void loadData() {
        movieList.add(new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015"));
        movieList.add(new MovieModel("Inside Out", "Animation, Kids & Family", "2015"));
        movieList.add(new MovieModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015"));
        movieList.add(new MovieModel("Shaun the Sheep", "Animation", "2015"));
        movieList.add(new MovieModel("The Martian", "Science Fiction & Fantasy", "2015"));
        movieList.add(new MovieModel("Mission: Impossible Rogue Nation", "Action", "2015"));
        movieList.add(new MovieModel("Up", "Animation", "2009"));
        movieList.add(new MovieModel("Star Trek", "Science Fiction", "2009"));
        movieList.add(new MovieModel("The LEGO Movie", "Animation", "2014"));
        movieList.add(new MovieModel("Iron Man", "Action & Adventure", "2008"));
        movieList.add(new MovieModel("Aliens", "Science Fiction", "1986"));
        movieList.add(new MovieModel("Chicken Run", "Animation", "2000"));
        movieList.add(new MovieModel("Back to the Future", "Science Fiction", "1985"));
        movieList.add(new MovieModel("Raiders of the Lost Ark", "Action & Adventure", "1981"));
        movieList.add(new MovieModel("Goldfinger", "Action & Adventure", "1965"));
        movieList.add(new MovieModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014"));
        mAdapter.notifyDataSetChanged();
    }
}