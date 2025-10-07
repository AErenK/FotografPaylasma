# 📷 Fotoğraf Paylaşma Uygulaması

Modern ve kullanıcı dostu bir Android fotoğraf paylaşım uygulaması. Firebase backend servisleri kullanılarak geliştirilmiştir.

## 🚀 Özellikler

- **🔐 Kullanıcı Kimlik Doğrulama**: Firebase Auth ile güvenli kayıt olma ve giriş yapma.
- **📸 Fotoğraf Yükleme**: Galeriden fotoğraf seçip Firebase Storage'a yükleme.
- **📱 Sosyal Feed**: Tüm kullanıcıların paylaştığı fotoğrafları görüntüleme.
- **👤 Profil Sayfası**: Kullanıcıya özel profil ekranı.
- **🎨 Gelişmiş UI**: `CollapsingToolbarLayout` ve özel alt navigasyon barı içeren dinamik ve modern arayüz.
- **📱 Responsive Design**: Farklı ekran boyutlarına uyumlu tasarım.

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

### UI/UX Kütüphaneleri
- **Material Components**: Modern UI bileşenleri
- **Picasso**: Görsel yükleme ve önbellekleme
- **ConstraintLayout**: Flexible layout yönetimi
- **CoordinatorLayout & CollapsingToolbarLayout**: Gelişmiş kaydırma ve daraltılabilir `Toolbar` efektleri.

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
    ├── KullaniciFragment.kt     # Kullanıcı girişi/kayıt
    ├── FeedFragment.kt          # Ana feed ekranı
    ├── YuklemeFragment.kt       # Fotoğraf yükleme
    └── ProfilFragment.kt        # Kullanıcı profili

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

### Navigasyon
- **Ana Menü (Sol Alt Buton)**: Feed'i en başa kaydırır ve üst banner'ı görünür kılar.
- **Yeni Gönderi (Orta Alt Buton)**: Fotoğraf yükleme sayfasına gider.
- **Profil (Sağ Alt Buton)**: Profil sayfanızı açar.
- **Üst Menü (Sağ Üstteki Üç Nokta)**: "Fotoğraf Paylaş" ve "Oturumu Kapat" seçeneklerini içerir.

### Fotoğraf Paylaşma
1. Alt menüdeki ortadaki **+** butonuna veya üst menüdeki "Fotoğraf Paylaş" seçeneğine tıklayın.
2. Galeriden bir fotoğraf seçin.
3. Bir yorum ekleyin.
4. "Yükle" butonuna tıklayarak gönderinizi paylaşın.

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

Uygulama, tek Activity ve çoklu Fragment yapısını benimser. Fragment geçişleri **Navigation Component** ile yönetilir:

```
KullaniciFragment ←→ FeedFragment

FeedFragment → YuklemeFragment
FeedFragment → ProfilFragment
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

- **Material Design 3**: Modern ve tutarlı tasarım.
- **CollapsingToolbarLayout**: Kaydırıldığında daralan dinamik üst banner.
- **Custom Bottom Bar**: Ana işlevlere (Feed, Yükleme, Profil) hızlı erişim.
- **Smooth Animations**: Fragment geçişlerinde akıcı animasyonlar.
- **Responsive Cards**: Fotoğraf gösterimleri için şık kart tasarımı.

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

### v1.1.0 (Şu anki)
- ✅ Temel kullanıcı kimlik doğrulama
- ✅ Fotoğraf yükleme ve paylaşma
- ✅ Feed görüntüleme
- ✅ Profil sayfası
- ✅ Gelişmiş UI (CollapsingToolbar, Bottom Bar)

### Gelecek Versiyonlar
- 🔐 Fotoğraf beğenme sistemi
- 💬 Gelişmiş yorum sistemi (yanıtlama, düzenleme)
- 🔍 Arama özelliği (kullanıcı veya etiket arama)
- 📲 Anlık bildirimler (yeni takipçi, beğeni vb.)

---
