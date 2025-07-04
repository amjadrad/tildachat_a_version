//package ir.tildaweb.tildachat_av.adapter;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//import android.widget.Filter;
//import android.widget.Filterable;
//
//public class PopupListAdapter<T> extends ArrayAdapter<T> implements Filterable {
//
//    private ArrayList<T> mOriginalValues;
//    private List<T> mObjects;
//    private CustomFilter mFilter;
//    private final Object mLock = new Object();
//    private Drawable[] icons;
//
//    public PopupListAdapter(Context context, int textViewResourceId, T[] objects, Drawable[] icons) {
//        super(context, textViewResourceId, objects);
//
//        mObjects = Arrays.asList(objects);
//        this.icons = icons;
//        // TODO Auto-generated constructor stub
//    }
//
//    @Override
//    public Filter getFilter() {
//        // TODO Auto-generated method stub
//        if (mFilter == null) {
//            mFilter = new CustomFilter();
//        }
//        return mFilter;
//    }
//
//
//
//    private class CustomFilter extends Filter {
//        @Override
//        protected FilterResults performFiltering(CharSequence prefix) {
//            FilterResults results = new FilterResults();
//            Log.d("bajji", "its ---> " + prefix);
//            if (mOriginalValues == null) {
//                synchronized (mLock) {
//                    mOriginalValues = new ArrayList<T>(mObjects);
//                }
//            }
//
//            if (prefix == null || prefix.length() == 0) {
//                ArrayList<T> list;
//                synchronized (mLock) {
//                    list = new ArrayList<T>(mOriginalValues);
//                }
//                results.values = list;
//                results.count = list.size();
//            } else {
//                String prefixString = prefix.toString().toLowerCase();
//
//                ArrayList<T> values;
//                synchronized (mLock) {
//                    values = new ArrayList<T>(mOriginalValues);
//                }
//
//                final int count = values.size();
//                final ArrayList<T> newValues = new ArrayList<T>();
//                final ArrayList<T> approxValues = new ArrayList<T>();
//                final ArrayList<T> secondApproxValues = new ArrayList<T>();
//
//
//                for (int i = 0; i < count; i++) {
//                    final T value = values.get(i);
//                    final String valueText = value.toString().toLowerCase();
//                    boolean flag = true;
//                    // First match against the whole, non-splitted value
//                    if (valueText.startsWith(prefixString)) {
//                        newValues.add(value);
//                        flag = false;
//                    } else {
//                        final String[] words = valueText.split(" ");
//                        final int wordCount = words.length;
//
//                        // Start at index 0, in case valueText starts with space(s)
//                        for (int k = 0; k < wordCount; k++) {
//                            if (words[k].startsWith(prefixString)) {
//                                newValues.add(value);
//                                flag = false;
//                                break;
//                            }
//                        }
//                    }
//
//                    if (flag) {
//                        if (approxMatch(valueText, prefixString) <= 3) { //change the stuff and do a levi work
//                            approxValues.add(value);
//                        } else {
//                            final String[] words = valueText.split(" ");
//                            final int wordCount = words.length;
//
//                            // Start at index 0, in case valueText starts with space(s)
//                            for (int k = 0; k < wordCount; k++) {
//                                if (approxMatch(words[k], prefixString) <= 3) {
//                                    //leve work
//                                    secondApproxValues.add(value);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//                newValues.addAll(approxValues);
//                newValues.addAll(secondApproxValues);
//                results.values = newValues;
//                results.count = newValues.size();
//            }
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            //noinspection unchecked
//            mObjects = (List<T>) results.values;
//            if (results.count > 0) {
//                notifyDataSetChanged();
//            } else {
//                notifyDataSetInvalidated();
//            }
//        }
//    }
//
////    private int approxMatch (String s, String t) {
////        // an approxmimate string matching algo
////        return p;
////    }
//}
