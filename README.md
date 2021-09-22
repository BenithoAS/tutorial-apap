# Tutorial APAP 
## Authors 
* **<Nama BENITHO AHMAD SURYO>** - *<NPM 1906353630>* - *<Kelas A>*

## Tutorial 1
### What I have learned today(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Andajuga boleh menambahkan catatan apapun di bagian ini)

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?(Tuliskan jawabanmu)
Issue Tracker merupakan alat untuk merekam masalah yang dialami oleh pengguna, dengan program dan memungkinkan untuk memberikan troubleshoot untuk menyelesaikan bugs yang ada
2. Apa perbedaan dari git merge dan git merge --squash?
Perbedaannya adalah squash merge hanya akan merge commit pada 1 parent dan file yang akan dimerge harus sama dengan yang di normal merge tetapi commit metadata akan beruabh untuk menunjukan hanya 1 parent commits
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
-Tracebility, mekanisme yang memberi history dari semua perubahan yang dilakukan, dengan ini pengguna dapat mengidentifikasi pengembangan aplikasi
-Branching And Merging, memungkinkan untuk anggota tim untuk mengerjakan pengembangan aplikasi secara bersamaan dengan independen satu sama lain
### Spring
4. Apa itu library & dependency?
Library merupakan koleksi dari non-volatile resources yang digunakan dalam computer programs maupun software development, depedency merupakan relationship diantara code, dimana code pertama akan memanggil kode kedua untuk melakukan action maupununtuk return infomation
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven merupakan java build tools yang menggunakan Projrct Object Model, yang berisi informasi dan konfigurasi yang digunakan maven untuk membuat project. Maven memiliki keunggulan dalam mebuat sturuktur projrctnya sendiri sehingga memudahkan untuk memanage depedency. Alternatif dari maven sendiri yaitu dapat menggunakan eclipse
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Selain dengan pengembangan web, developer juga dapat mengembangkan aplikasi enterprise dengan menggunakan spring frame work
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
@RequestParam digunakan untuk extract query parameter sedangkan @PathVariable digunakan untuk mengextarct data yang langsung daru url. @RequestParam lebih baik digunakan untuk traditional web application dimana data lebih sering lewat query, dan pada @PathVariable lebih sesuai digunakan pada restful web services dimana url berisi values data\

### What I did not understand(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Andasudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [x] Keterhubungan model dan controller

## Tutorial 2

#### Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut  setelah  menjalankan  program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat  terjadi
Akan terjadi error dikarenakan pada bagian view dari “add-kebun-safari" belum dibuat

#### Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired  tersebut  dalam  konteks  service  dan  controller  yang  telah  kamu  buat
Pada @Autowired di controller mengimplementasikan konsep @Autowired on Properties. Dimana @Autowired akan mengurangi kebutuhan untuk melakukan getter dan setter, dengan cara inject bean tersebut ke KebunSafariController bean dengan menggunakan @Autowired, setelah itu Spring meng-inject kebunSafariService ketika KebunSafariController dibuat

#### Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom Apa  yang  terjadi?  Jelaskan  mengapa  hal tersebut  dapat  terjadi.
Terjadinya error karena pada saat penambahan tidak terdapat informasi tentang nomor telepon

#### Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link  apa  yang  harus  diakses?
http://localhost:8080/kebun-safari/?id=1

#### Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti  screenshotmu.
Akan menampilkan seluruh kebun safari
link screenshoot : https://drive.google.com/drive/folders/1aogtC0S_hzAMzGSNqJ4o_JIe9etz4yFh?usp=sharing


