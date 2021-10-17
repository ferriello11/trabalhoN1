package com.fabiano.appformularion1;

public class Formulario {

        private int id;
        private String nome;
        private String email;
        private String profissao;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getProfissao() {
            return profissao;
        }

        public void setProfissao(String profissao) {
            this.profissao = profissao;
        }

        @Override
        public String toString() {
            return  " id:" + id +
                    " nome: " + nome +
                    " email: " + email +
                    " profissao: " + profissao ;
        }
}
