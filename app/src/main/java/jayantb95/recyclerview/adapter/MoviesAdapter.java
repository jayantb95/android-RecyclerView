package jayantb95.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jayantb95.recyclerview.R;
import jayantb95.recyclerview.dataModel.MovieModel;

/**
 * Created by Jayant on 18-01-2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<MovieModel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView edtTitle;
        public TextView edtYear;
        public TextView edtGenre;

        public MyViewHolder(View view) {
            super(view);
            edtTitle = (TextView) view.findViewById(R.id.edt_title_item);
            edtGenre = (TextView) view.findViewById(R.id.edt_genre_item);
            edtYear = (TextView) view.findViewById(R.id.edt_year_item);
        }
    }

    public MoviesAdapter(List<MovieModel> movieList) {
        this.moviesList = movieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieModel movie = moviesList.get(position);
        holder.edtTitle.setText(movie.getTitle());
        holder.edtGenre.setText(movie.getGenre());
        holder.edtYear.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
