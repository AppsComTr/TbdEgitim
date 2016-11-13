Bu modül harici kütühaneleri nasıl entegre edebileceginizi gosterir.
Kullanabileceğiniz iki tür entegre yontemi var.

    1)Gradle dependency olarak eklemek.
      Modülünüzün build.gradle dosyasında 'dependency' blogunun icerisine gerekli linki yazın ve tekrar derlemesini bekleyin.

    2)Kütühanenin kaynak kodlarını direk proje içerisine koymak
      Projenize sağ tıklayın ve New->Module->Import Gradle Project takip edin ve kütüphanenizin kalsörünü gösterin.
      Yine kendi modülünüzün build.gradle dosyasına girin ve 'dependency' blogunun içerisine compile project (':<your_library_module_name>') linkini yazıp tekrar derlemesini bekleyin.
