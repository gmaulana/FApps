package com.noobdev.gilang.views;
import android.util.Log;

//Tanggal : 12 agustus 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3

import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data


    public void save(final friend temanModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(friend.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    temanModel.setId(nextId);
                    friend model = realm.copyToRealm(temanModel);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<friend> getAllMahasiswa(){
        RealmResults<friend> results = realm.where(friend.class).findAll();
        return results;
    }

    // untuk meng-update data
    public void update(final Integer id, final String nim, final String nama, final String kelas, final String telepon, final String email, final String sosmed){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                friend model = realm.where(friend.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNim(nim);
                model.setNama(nama);
                model.setEmail(email);
                model.setKelas(kelas);
                model.setTelepon(telepon);
                model.setSosmed(sosmed);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    // untuk menghapus data
    public void delete(Integer id){
        final RealmResults<friend> model = realm.where(friend.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }
}
