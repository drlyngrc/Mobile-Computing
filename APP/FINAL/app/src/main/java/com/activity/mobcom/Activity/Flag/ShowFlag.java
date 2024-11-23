package com.activity.mobcom.Activity.Flag;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.activity.mobcom.Adapter.FlagAdapter;
import com.activity.mobcom.Domain.FlagDomain;
import com.activity.mobcom.R;

import java.util.ArrayList;
import java.util.List;

public class ShowFlag extends AppCompatActivity {

    private List<FlagDomain> countries;
    private List<FlagDomain> filteredCountries;
    private FlagAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_flag);

        RecyclerView recyclerView = findViewById(R.id.view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countries = new ArrayList<>();
        filteredCountries = new ArrayList<>();

        countries.add(new FlagDomain("Afghanistan", R.drawable.ad));
        countries.add(new FlagDomain("Albania", R.drawable.al));
        countries.add(new FlagDomain("Algeria", R.drawable.alg));
        countries.add(new FlagDomain("Andorra", R.drawable.ad));
        countries.add(new FlagDomain("Angola", R.drawable.ao));
        countries.add(new FlagDomain("Antigua and Barbuda", R.drawable.ag));
        countries.add(new FlagDomain("Argentina", R.drawable.ar));
        countries.add(new FlagDomain("Armenia", R.drawable.am));
        countries.add(new FlagDomain("Australia", R.drawable.au));
        countries.add(new FlagDomain("Austria", R.drawable.at));
        countries.add(new FlagDomain("Azerbaijan", R.drawable.az));
        countries.add(new FlagDomain("Bahamas", R.drawable.bs));
        countries.add(new FlagDomain("Bahrain", R.drawable.bh));
        countries.add(new FlagDomain("Bangladesh", R.drawable.bd));
        countries.add(new FlagDomain("Barbados", R.drawable.bb));
        countries.add(new FlagDomain("Belarus", R.drawable.by));
        countries.add(new FlagDomain("Belgium", R.drawable.be));
        countries.add(new FlagDomain("Belize", R.drawable.bz));
        countries.add(new FlagDomain("Benin", R.drawable.bj));
        countries.add(new FlagDomain("Bermuda", R.drawable.bm));
        countries.add(new FlagDomain("Bhutan", R.drawable.bt));
        countries.add(new FlagDomain("Bolivia", R.drawable.bo));
        countries.add(new FlagDomain("Bosnia and Herzegovina", R.drawable.ba));
        countries.add(new FlagDomain("Botswana", R.drawable.bw));
        countries.add(new FlagDomain("Brazil", R.drawable.br));
        countries.add(new FlagDomain("Brunei", R.drawable.bn));
        countries.add(new FlagDomain("Bulgaria", R.drawable.bg));
        countries.add(new FlagDomain("Burundi", R.drawable.bi));
        countries.add(new FlagDomain("Cambodia", R.drawable.kh));
        countries.add(new FlagDomain("Cameroon", R.drawable.cm));
        countries.add(new FlagDomain("Canada", R.drawable.ca));
        countries.add(new FlagDomain("Central African Republic", R.drawable.cf));
        countries.add(new FlagDomain("Chad", R.drawable.td));
        countries.add(new FlagDomain("Chile", R.drawable.cl));
        countries.add(new FlagDomain("China", R.drawable.cn));
        countries.add(new FlagDomain("Colombia", R.drawable.co));
        countries.add(new FlagDomain("Comoros", R.drawable.km));
        countries.add(new FlagDomain("Congo", R.drawable.cd));
        countries.add(new FlagDomain("Costa Rica", R.drawable.cr));
        countries.add(new FlagDomain("Croatia", R.drawable.hr));
        countries.add(new FlagDomain("Cuba", R.drawable.cu));
        countries.add(new FlagDomain("Cyprus", R.drawable.cy));
        countries.add(new FlagDomain("Czechia", R.drawable.cz));
        countries.add(new FlagDomain("Denmark", R.drawable.dk));
        countries.add(new FlagDomain("Djibouti", R.drawable.dj));
        countries.add(new FlagDomain("Dominica", R.drawable.dm));
        countries.add(new FlagDomain("Dominican Republic", R.drawable.dom));
        countries.add(new FlagDomain("Ecuador", R.drawable.ec));
        countries.add(new FlagDomain("Egypt", R.drawable.eg));
        countries.add(new FlagDomain("El Salvador", R.drawable.sv));
        countries.add(new FlagDomain("Equatorial Guinea", R.drawable.gq));
        countries.add(new FlagDomain("Eritrea", R.drawable.er));
        countries.add(new FlagDomain("Estonia", R.drawable.ee));
        countries.add(new FlagDomain("Eswatini", R.drawable.sz));
        countries.add(new FlagDomain("Ethiopia", R.drawable.et));
        countries.add(new FlagDomain("Fiji", R.drawable.fj));
        countries.add(new FlagDomain("Finland", R.drawable.fi));
        countries.add(new FlagDomain("France", R.drawable.fr));
        countries.add(new FlagDomain("Gabon", R.drawable.ga));
        countries.add(new FlagDomain("Gambia", R.drawable.gm));
        countries.add(new FlagDomain("Georgia", R.drawable.ge));
        countries.add(new FlagDomain("Germany", R.drawable.de));
        countries.add(new FlagDomain("Ghana", R.drawable.gh));
        countries.add(new FlagDomain("Greece", R.drawable.gr));
        countries.add(new FlagDomain("Greenland", R.drawable.gl));
        countries.add(new FlagDomain("Grenada", R.drawable.gd));
        countries.add(new FlagDomain("Guam", R.drawable.gu));
        countries.add(new FlagDomain("Guatemala", R.drawable.gt));
        countries.add(new FlagDomain("Guinea", R.drawable.gn));
        countries.add(new FlagDomain("Guinea-Bissau", R.drawable.gw));
        countries.add(new FlagDomain("Guyana", R.drawable.gy));
        countries.add(new FlagDomain("Haiti", R.drawable.ht));
        countries.add(new FlagDomain("Honduras", R.drawable.hn));
        countries.add(new FlagDomain("Hong Kong", R.drawable.hk));
        countries.add(new FlagDomain("Hungary", R.drawable.hu));
        countries.add(new FlagDomain("Iceland", R.drawable.is));
        countries.add(new FlagDomain("India", R.drawable.in));
        countries.add(new FlagDomain("Indonesia", R.drawable.id));
        countries.add(new FlagDomain("Iran", R.drawable.ir));
        countries.add(new FlagDomain("Iraq", R.drawable.iq));
        countries.add(new FlagDomain("Ireland", R.drawable.ie));
        countries.add(new FlagDomain("Israel", R.drawable.il));
        countries.add(new FlagDomain("Italy", R.drawable.it));
        countries.add(new FlagDomain("Jamaica", R.drawable.jm));
        countries.add(new FlagDomain("Japan", R.drawable.jp));
        countries.add(new FlagDomain("Jersey", R.drawable.je));
        countries.add(new FlagDomain("Jordan", R.drawable.jo));
        countries.add(new FlagDomain("Kazakhstan", R.drawable.kz));
        countries.add(new FlagDomain("Kenya", R.drawable.ke));
        countries.add(new FlagDomain("Kiribati", R.drawable.ki));
        countries.add(new FlagDomain("North Korea", R.drawable.kp));
        countries.add(new FlagDomain("South Korea", R.drawable.kr));
        countries.add(new FlagDomain("Kuwait", R.drawable.kw));
        countries.add(new FlagDomain("Kyrgyzstan", R.drawable.kg));
        countries.add(new FlagDomain("Laos", R.drawable.la));
        countries.add(new FlagDomain("Latvia", R.drawable.lv));
        countries.add(new FlagDomain("Lebanon", R.drawable.lb));
        countries.add(new FlagDomain("Lesotho", R.drawable.ls));
        countries.add(new FlagDomain("Liberia", R.drawable.lr));
        countries.add(new FlagDomain("Libya", R.drawable.ly));
        countries.add(new FlagDomain("Liechtenstein", R.drawable.li));
        countries.add(new FlagDomain("Lithuania", R.drawable.lt));
        countries.add(new FlagDomain("Luxembourg", R.drawable.lu));
        countries.add(new FlagDomain("Macau", R.drawable.mo));
        countries.add(new FlagDomain("Madagascar", R.drawable.mg));
        countries.add(new FlagDomain("Malawi", R.drawable.mw));
        countries.add(new FlagDomain("Malaysia", R.drawable.my));
        countries.add(new FlagDomain("Maldives", R.drawable.mv));
        countries.add(new FlagDomain("Mali", R.drawable.ml));
        countries.add(new FlagDomain("Malta", R.drawable.mt));
        countries.add(new FlagDomain("Marshall Islands", R.drawable.mh));
        countries.add(new FlagDomain("Mauritania", R.drawable.mr));
        countries.add(new FlagDomain("Mauritius", R.drawable.mu));
        countries.add(new FlagDomain("Mexico", R.drawable.mx));
        countries.add(new FlagDomain("Micronesia", R.drawable.fm));
        countries.add(new FlagDomain("Moldova", R.drawable.md));
        countries.add(new FlagDomain("Monaco", R.drawable.mc));
        countries.add(new FlagDomain("Mongolia", R.drawable.mn));
        countries.add(new FlagDomain("Montenegro", R.drawable.me));
        countries.add(new FlagDomain("Morocco", R.drawable.ma));
        countries.add(new FlagDomain("Mozambique", R.drawable.mz));
        countries.add(new FlagDomain("Myanmar", R.drawable.mm));
        countries.add(new FlagDomain("Namibia", R.drawable.na));
        countries.add(new FlagDomain("Nauru", R.drawable.nr));
        countries.add(new FlagDomain("Nepal", R.drawable.np));
        countries.add(new FlagDomain("Netherlands", R.drawable.nl));
        countries.add(new FlagDomain("New Zealand", R.drawable.nz));
        countries.add(new FlagDomain("Nicaragua", R.drawable.ni));
        countries.add(new FlagDomain("Niger", R.drawable.ne));
        countries.add(new FlagDomain("Nigeria", R.drawable.ng));
        countries.add(new FlagDomain("North Macedonia", R.drawable.mk));
        countries.add(new FlagDomain("Norway", R.drawable.sj));
        countries.add(new FlagDomain("Oman", R.drawable.om));
        countries.add(new FlagDomain("Pakistan", R.drawable.pk));
        countries.add(new FlagDomain("Palau", R.drawable.pw));
        countries.add(new FlagDomain("Palestine", R.drawable.ps));
        countries.add(new FlagDomain("Panama", R.drawable.pa));
        countries.add(new FlagDomain("Papua New Guinea", R.drawable.pg));
        countries.add(new FlagDomain("Paraguay", R.drawable.py));
        countries.add(new FlagDomain("Peru", R.drawable.pe));
        countries.add(new FlagDomain("Philippines", R.drawable.ph));
        countries.add(new FlagDomain("Poland", R.drawable.pl));
        countries.add(new FlagDomain("Portugal", R.drawable.pt));
        countries.add(new FlagDomain("Qatar", R.drawable.qa));
        countries.add(new FlagDomain("Romania", R.drawable.ro));
        countries.add(new FlagDomain("Russia", R.drawable.ru));
        countries.add(new FlagDomain("Rwanda", R.drawable.rw));
        countries.add(new FlagDomain("Saint Kitts and Nevis", R.drawable.kn));
        countries.add(new FlagDomain("Saint Lucia", R.drawable.lc));
        countries.add(new FlagDomain("Saint Vincent and the Grenadines", R.drawable.vc));
        countries.add(new FlagDomain("Samoa", R.drawable.ws));
        countries.add(new FlagDomain("San Marino", R.drawable.sm));
        countries.add(new FlagDomain("Sao Tome and Principe", R.drawable.st));
        countries.add(new FlagDomain("Saudi Arabia", R.drawable.sa));
        countries.add(new FlagDomain("Scotland", R.drawable.sct));
        countries.add(new FlagDomain("Senegal", R.drawable.sn));
        countries.add(new FlagDomain("Serbia", R.drawable.rs));
        countries.add(new FlagDomain("Seychelles", R.drawable.sc));
        countries.add(new FlagDomain("Sierra Leone", R.drawable.sl));
        countries.add(new FlagDomain("Singapore", R.drawable.sg));
        countries.add(new FlagDomain("Slovakia", R.drawable.sk));
        countries.add(new FlagDomain("Slovenia", R.drawable.si));
        countries.add(new FlagDomain("Solomon Islands", R.drawable.sb));
        countries.add(new FlagDomain("Somalia", R.drawable.so));
        countries.add(new FlagDomain("South Africa", R.drawable.za));
        countries.add(new FlagDomain("South Sudan", R.drawable.ss));
        countries.add(new FlagDomain("Spain", R.drawable.es));
        countries.add(new FlagDomain("Sri Lanka", R.drawable.lk));
        countries.add(new FlagDomain("Sudan", R.drawable.sd));
        countries.add(new FlagDomain("Suriname", R.drawable.sr));
        countries.add(new FlagDomain("Sweden", R.drawable.se));
        countries.add(new FlagDomain("Switzerland", R.drawable.ch));
        countries.add(new FlagDomain("Syria", R.drawable.sy));
        countries.add(new FlagDomain("Taiwan", R.drawable.tw));
        countries.add(new FlagDomain("Tajikistan", R.drawable.tj));
        countries.add(new FlagDomain("Tanzania", R.drawable.tz));
        countries.add(new FlagDomain("Thailand", R.drawable.th));
        countries.add(new FlagDomain("Timor-Leste", R.drawable.tl));
        countries.add(new FlagDomain("Togo", R.drawable.tg));
        countries.add(new FlagDomain("Tonga", R.drawable.to));
        countries.add(new FlagDomain("Trinidad and Tobago", R.drawable.tt));
        countries.add(new FlagDomain("Tunisia", R.drawable.tn));
        countries.add(new FlagDomain("Turkey", R.drawable.tr));
        countries.add(new FlagDomain("Turkmenistan", R.drawable.tm));
        countries.add(new FlagDomain("Tuvalu", R.drawable.tv));
        countries.add(new FlagDomain("Uganda", R.drawable.ug));
        countries.add(new FlagDomain("Ukraine", R.drawable.ua));
        countries.add(new FlagDomain("United Arab Emirates", R.drawable.ae));
        countries.add(new FlagDomain("United Kingdom", R.drawable.gb));
        countries.add(new FlagDomain("United States", R.drawable.us));
        countries.add(new FlagDomain("Uruguay", R.drawable.uy));
        countries.add(new FlagDomain("Uzbekistan", R.drawable.uz));
        countries.add(new FlagDomain("Vanuatu", R.drawable.vu));
        countries.add(new FlagDomain("Vatican City", R.drawable.va));
        countries.add(new FlagDomain("Venezuela", R.drawable.ve));
        countries.add(new FlagDomain("Vietnam", R.drawable.vn));
        countries.add(new FlagDomain("Yemen", R.drawable.ye));
        countries.add(new FlagDomain("Zambia", R.drawable.zm));
        countries.add(new FlagDomain("Zimbabwe", R.drawable.zw));

        filteredCountries.addAll(countries);
        adapter = new FlagAdapter(this, filteredCountries);
        recyclerView.setAdapter(adapter);

        /*
        FlagAdapter adapter = new FlagAdapter(this, countries);
        recyclerView.setAdapter(adapter);
*/


        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());

        EditText searchInput = findViewById(R.id.search_input);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        filteredCountries.clear();
        if (text.isEmpty()) {
            filteredCountries.addAll(countries);
        } else {
            for (FlagDomain country : countries) {
                if (country.getName().toLowerCase().contains(text.toLowerCase())) {
                    filteredCountries.add(country);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
