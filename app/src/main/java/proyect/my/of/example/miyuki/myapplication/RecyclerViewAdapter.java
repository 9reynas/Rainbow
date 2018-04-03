package proyect.my.of.example.miyuki.myapplication;

import android.app.Fragment;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import proyect.my.of.example.miyuki.myapplication.Fragment_List.OnListFragmentInteractionListener;
import proyect.my.of.example.miyuki.myapplication.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Fragment fragment;


    private List<DummyItem> mValues;
    private OnListFragmentInteractionListener mListener;
    Interfaz minterfaz;


    public RecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener, Interfaz interfaz) {
        mValues = items;
        mListener = listener;
        minterfaz = interfaz;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);


        holder.parenLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "item: " + mValues.get(position).content, Snackbar.LENGTH_LONG).show();

                minterfaz.OpenFrag();


            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public DummyItem mItem;
        LinearLayout parenLayout;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);

            parenLayout = view.findViewById(R.id.linearcontainerID);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
