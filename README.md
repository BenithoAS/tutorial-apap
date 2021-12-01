# Tutorial APAP 
## Authors 
* **<Nama BENITHO AHMAD SURYO>** - *<NPM 1906353630>* - *<Kelas A>*

## Tutorial 7

#### Pertanyaan 1 : Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
Link Screenshoot (https://drive.google.com/drive/folders/1OKJs-uaInVk6I03Y1MeK3wbRgB3qDDRI?usp=sharing)
- Membuat fungsi baru bernama handleDeleteItemToCart, dimana berisi newItems untuk item yang berada di cart, delItem untuk item yang akan dipilih, lalu item yang dipilih akan dihapus dan setState({cartItems:newItems}) untuk mengubah kembali item yang ada di cart

- Menambahkan isi balance pada handleAddItemToCart dan handleDeleteItemToCart lalu menambahkan newItemPrice untuk harga dari barang yang baru dipilih dan delItemPrice untuk harga item yang akan dihapus, lalu pada newBalance di menambah barang, balance akan dikurangi newItemPrice dan di menghapus barang, balance akan ditambah delItemPrice. Setelah itu setState({ balance: newBalance }) untuk mengupdate dari total balance yang ada

- Menambahkan if(newBalance < 0) pada handleAddItemToCart ketika balance akan menjadi minus pada saat menambahkan barang, dan akan mengeluarkan alert yang berisi ("Balance not sufficient!")

#### Pertanyaan 2 : Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?

Perbedaan utama antara props dan state adalah, pada state bersifat internal dan dikendalikan oleh komponen itu sendiri sementara props bersifat eksternal dan dikendalikan oleh apa pun yang membuat komponen tersebut.

#### pertanyaan 3 : Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React?  sebutkan alasannya.

Dikarenakan ketika memakai komponen pada react akan memudahkan untuk membuat UI yang akan dipakai, karena bersifat independen dan reusable sehingga mempercepat dalam pembuatan proyek

#### Pertanyaan 4 : Apa perbedaan class component dan functional component?

- Class Components mengharuskan untuk meng-extend dari React, dan harus memiliki method render() yang mengembalikan HTML

- Functional component hanyalah fungsi JavaScript biasa yang menerima props sebagai argumen dan mengembalikan React element.

#### Pertanyaan 5 : Dalam react, apakah perbedaan component dan element?

- React component adalah sebuah template yang berupa fungsi atau kelas (dengan fungsi render).

- React Elements adalah apa yang di-return dari react component, dimana objek yang secara virtual menggambarkan DOM nodes yang diwakili oleh component.

## Tutorial 6

#### Pertanyaan 1: Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
- Otentikasi adalah proses untuk mengetahui siapa yang sedang mengakses aplikasi, diimplementasikan dalam class WebSecurityConfig, UserDetailsServiceImpl, dan data terkait user disimpan pada model
- Otorisasi adalah proses untuk menyesuaikan apa saja otorisasi yang bisa diperoleh suatu role, diimplementasikan dalam class WebSecurityConfig, dan pada bagian html

#### Pertanyaan 2: Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya
BCryptPasswordEncoder adalah implementasi dari algoritma BCrypt yang berfungsi dalam hashing password. Cara kerjanya dengan secara otomatis menghasilkan dan menggunakan random salt untuk menghitung hash, dengan tujuan untuk mendapatkan output yang berbeda.

#### Pertanyaan 3: Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
Menggunakan hashing karena ketika password menggunakan enkripsi, pasword akan memungkinkan untuk di-dekripsi, dan jika menggunakan hashing, hasil hash tidak dapat didekripsi.

#### Pertanyaan 4: Jelaskan secara singkat apa itu UUID beserta penggunaannya
UUID (Universally unique identifier) adalah proses yang dapat menghasilkan unique id secara universal, sehingga sangat kecil untuk mendapatkan id yang sama dalam satu sistem

#### Pertanyaan 5: Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
Class UserDetailsServiceImpl.java berguna untuk retrieving data dari database mengenai data user, lalu akan digunakan untuk proses otentikasi

## Tutorial 5

#### Pertanyaan 1: Apa itu Postman? Apa kegunaannya?
Postman merupakan platform API untuk membuat dan menggunakan API, dengan fitur API repository, tools, Intelligence, workspaces, dan integrations. 

#### Pertanyaan 2: Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
- @JsonIgnoreProperties digunakan untuk class dengan menandai atribut/properti yang akan diabaikan/ignore
- @JsonProperty digunakan untuk memetakan nama properti dengan JSON key pada serialization atau menunjukkan property name di JSON

#### Pertanyaan 3: Apa kegunaan atribut WebClient?
WebClient merupakan bagian dari Spring's  web reactive framework yang digunakan untuk melakukan HTTP request dan  digunakan untuk membangun aplikasi yang reactive.

#### Pertanyaan 4: Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
- ResponseEntity merupakan entitas yang ada pada HTTP yaitu body, header, dan status yang digunakan untuk mengontrol respon HTTP. 
- BindingResult merupakan objek dari Spring yang menyimpan hasil validasi dan berisi error yang mungkin terjadi.

## Tutorial 4

#### Pertanyaan 1: Jelaskan perbedaan th:include dan th:replace!
 - th:include: fragment/konten akan masuk ke dalam objek html
 - th:replace: fragment/konten akan menggantikan posisi objek html

#### Pertanyaan 2: Jelaskan  apa  fungsi  dari  th:object!
th:object berfungsi untuk menginisisasi objek yang kemudian data yg dikirim dapat diterima berdasarkan tabel data yang bersesuaian oleh spring

#### Pertanyaan 3: Jelaskan  perbedaan  dari  *  dan  $  pada  saat  penggunaan  th:object!  Kapan  harus  dipakai?
- "*" digunakan untuk mengambil atribut dari data yang dipilih sebelumnya menggunakan "$"
- "$" digunakan untuk inisiasi variable yg dikirim oelh spring controller

## Tutorial 3

#### Pertanyaan 1: Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor,  @NoArgsConstructor,  @Setter,  @Getter,  @Entity,  @Table)
 - @AllArgsConstructor : menghasilkan constructor yang membutuhkan argumen untuk setiap field pada annotated class
 - @NoArgsConstructor : menghasilkan constructor yang default dan tanpa parameter
 - @Setter : untuk menghasilkan setter yang default secara otomatis
 - @Getter : untuk menghasilkan getter yang default secara otomatis
 - @Entity : untuk menghasilkan entity secara default dan otomatis
 - @Table : untuk menghasilkan table dengan nama yang sesuai dengan yang diisi

#### Pertanyaan 2: Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method tersebut?
Untuk mencari data cabang menggunakan nomor cabang yang diketahui

#### Pertanyaan 3: Jelaskan  perbedaan  kegunaan  dari  anotasi  @JoinTable  dan  @JoinColumn
@JoinTable akan menyimpan id kedua entity ke dalam table terpisah sedangkan @JoinColumn akan menyimpan id entity lain di column baru di table yang sama

#### Pertanyaan 4: Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan  nullable  dan  penggunaan  anotasi  @NotNull
name digunakan untuk membuat relasi pada noCabang table pegawai, sedangkan referencedColumnName digunakan untuk relasi pada noCabang table cabang. nullable menunjukkan variabel, parameter yang boleh bernilai null berdasarkan dengan isiannya, sedangkan @NotNull menunjukkan variabel, parameter yang tidak boleh bernilai null 

#### Pertanyaan 5: Jelaskan  kegunaan  FetchType.LAZY,  CascadeType.ALL,  dan  FetchType.EAGER
- FetchType.LAZY : fetch akan dilakukan jika hanya dibutuhkan saja
- FetchType.EAGER : fetch akan langsung dilakukan
- CascadeType.ALL : akan menyebarkan (cascade) ke semua EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) ke relating entities

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




