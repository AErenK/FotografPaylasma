# 📷 Fotoğraf Paylaşma Uygulaması

Modern ve kullanıcı dostu bir Android fotoğraf paylaşım uygulaması. Firebase backend servisleri kullanılarak geliştirilmiştir.

## 🚀 Özellikler

- **🔐 Kullanıcı Kimlik Doğrulama**: Firebase Auth ile güvenli kayıt olma ve giriş yapma
- **📸 Fotoğraf Yükleme**: Galeriden fotoğraf seçip Firebase Storage'a yükleme
- **📱 Sosyal Feed**: Tüm kullanıcıların paylaştığı fotoğrafları görüntüleme
- **💬 Yorum Sistemi**: Fotoğraflara yorum ekleme
- **🎨 Modern UI**: Material Design 3 prensipleriyle tasarlanmış arayüz
- **📱 Responsive Design**: Farklı ekran boyutlarına uyumlu tasarım

## 🛠️ Teknoloji Stack

### Android
- **Kotlin**: Ana programlama dili
- **Android SDK**: API Level 24-36 arası destek
- **View Binding**: Type-safe view referansları
- **Navigation Component**: Fragment geçişleri için
- **RecyclerView**: Fotoğraf listesi gösterimi

### Firebase
- **Firebase Authentication**: Kullanıcı yönetimi
- **Firebase Firestore**: Veritabanı (gönderiler, yorumlar)
- **Firebase Storage**: Fotoğraf depolama
- **Firebase Analytics**: Uygulama analitikleri

### UI/UX Kütüphaneleri
- **Material Components**: Modern UI bileşenleri
- **Picasso**: Görsel yükleme ve önbellekleme
- **ConstraintLayout**: Flexible layout yönetimi
- **CoordinatorLayout**: Advanced scroll behavior

## 📋 Gereksinimler

- Android 7.0 (API level 24) ve üzeri
- Internet bağlantısı (Firebase servisleri için)
- Galeri erişim izni (fotoğraf seçimi için)

## 🏗️ Proje Yapısı

```
app/src/main/java/com/example/fotografpaylasma/
├── adapter/
│   └── PostAdapter.kt           # RecyclerView için adapter
├── model/
│   └── Post.kt                  # Gönderi veri modeli
└── view/
    ├── MainActivity.kt          # Ana activity
    ├── KullaniciFragment.kt     # Kullanıcı girişi
    ├── FeedFragment.kt          # Ana feed ekranı
    └── YuklemeFragment.kt       # Fotoğraf yükleme

app/src/main/res/
├── layout/                      # Layout dosyaları
├── navigation/                  # Navigation graph
├── menu/                        # Menü dosyaları
└── values/                      # Renkler, stringler, temalar
```

## ⚡ Kurulum

1. **Depoyu klonlayın:**
   ```bash
   git clone https://github.com/AErenK/FotografPaylasma.git
   cd FotografPaylasma
   ```

2. **Android Studio'da açın:**
   - Android Studio'yu başlatın
   - "Open an existing Android Studio project" seçin
   - Proje klasörünü seçin

3. **Firebase yapılandırması:**
   - Firebase Console'da yeni proje oluşturun
   - Android uygulaması ekleyin (package name: `com.example.fotografpaylasma`)
   - `google-services.json` dosyasını `app/` klasörüne koyun
   - Authentication, Firestore ve Storage servislerini etkinleştirin

4. **Uygulamayı çalıştırın:**
   - Sync Project with Gradle Files
   - Run 'app' (Shift + F10)

## 🎮 Kullanım

### İlk Kullanım
1. Uygulamayı açın
2. Email ve şifre ile kayıt olun
3. Otomatik olarak ana feed ekranına yönlendirilirsiniz

### Fotoğraf Paylaşma
1. Feed ekranında sağ alt köşedeki **+** butonuna tıklayın
2. "Fotoğraf Paylaş" seçeneğini seçin
3. Galeriden fotoğraf seçin
4. Yorum ekleyin
5. "Yükle" butonuna tıklayın

### Feed'i Görüntüleme
- Ana ekranda tüm kullanıcıların paylaştığı fotoğrafları görüntüleyebilirsiniz
- Fotoğraflar en yeniden eski sıraya göre listelenir
- Her gönderide kullanıcı emaili, fotoğraf ve yorum görünür

## 🔧 Yapılandırma

### Gradle Yapılandırması
```kotlin
android {
    compileSdk = 36
    minSdk = 24
    targetSdk = 36
    
    buildFeatures {
        viewBinding = true
    }
}
```

### İzinler
```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
```

## 🏛️ Mimari

Uygulama **MVVM (Model-View-ViewModel)** benzeri bir mimari kullanır:

- **Model**: Firebase'den gelen veriler (`Post.kt`)
- **View**: Fragment'lar ve Activity'ler (UI katmanı)
- **Adapter**: RecyclerView için veri bağlama katmanı

### Navigation Component
Uygulama tek Activity çoklu Fragment mimarisi kullanır:
```
KullaniciFragment ←→ FeedFragment ←→ YuklemeFragment
```

## 🔥 Firebase Servisleri

### Authentication
```kotlin
auth.createUserWithEmailAndPassword(email, password)
auth.signInWithEmailAndPassword(email, password)
```

### Firestore
```kotlin
db.collection("Posts").orderBy("date", Query.Direction.DESCENDING)
```

### Storage
```kotlin
storage.reference.child("images").child("${uuid}.jpg")
```

## 🎨 UI/UX Özellikleri

- **Material Design 3**: Modern ve tutarlı tasarım
- **Dark/Light Theme**: Sistem temasını takip eder
- **Smooth Animations**: Fragment geçişlerinde akıcı animasyonlar
- **Responsive Cards**: Fotoğraf gösterimleri için şık kart tasarımı
- **Floating Action Button**: Hızlı erişim için FAB kullanımı

## 🚨 Bilinen Sorunlar

- Java 25 uyumluluğu: Kotlin Language Server ile uyumluluk sorunu
- Önerilen çözüm: Java 17 veya 21 kullanımı

## 🤝 Katkıda Bulunma

1. Fork edin
2. Feature branch oluşturun (`git checkout -b feature/yeni-ozellik`)
3. Commit yapın (`git commit -am 'Yeni özellik eklendi'`)
4. Branch'i push edin (`git push origin feature/yeni-ozellik`)
5. Pull Request oluşturun

## 📄 Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasına bakın.

## 👨‍💻 Geliştirici

**Eren K** - [AErenK](https://github.com/AErenK)

## 📞 İletişim

Proje hakkında sorularınız için:
- GitHub Issues bölümünü kullanabilirsiniz
- Email: [geliştirici email adresi]

## 🔄 Versiyonlar

### v1.0.0 (Şu anki)
- ✅ Temel kullanıcı kimlik doğrulama
- ✅ Fotoğraf yükleme ve paylaşma
- ✅ Feed görüntüleme
- ✅ Material Design 3 UI

### Gelecek Versiyonlar
- 🔲 Profil sayfası
- 🔐 Fotoğraf beğenme sistemi
- 💬 Gelişmiş yorum sistemi
- 🔍 Arama özelliği
- 📲 Push notification'lar

---

⭐ **Bu projeyi beğendiyseniz bir yıldız bırakmayı unutmayın!**
