package com.noobdev.gilang.model;

public class friend {
        private String nama;
        private String npm;
        private String nohp;

        public friend(String nama, String npm, String nohp) {
            this.nama = nama;
            this.npm = npm;
            this.nohp = nohp;

        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNpm() {
            return npm;
        }

        public void setNpm(String npm) {
            this.npm = npm;
        }

        public String getNohp() {
            return nohp;
        }

        public void setNohp(String nohp) {
            this.nohp = nohp;
        }
    }

