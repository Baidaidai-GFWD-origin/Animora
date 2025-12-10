# Jetpack Compose 动画 API 补充计划

这是一个用于完善当前动画组件库的待办事项列表，其中包含了待补充 API 的全称，方便查找签名并实现。

## 基础补充 (完善核心功能)

- [ ] **`androidx.compose.animation.core.Animatable`**
    - **用途**: 实现完全自定义和可中断的动画，是所有高级动画的基础。通过协程驱动，提供精细控制。

- [ ] **`androidx.compose.animation.AnimatedContent`**
    - **用途**: 一个强大的容器 Composable，用于在内容（状态）发生变化时，应用复杂的 `ContentTransform`（例如平移、缩放、淡入淡出组合）来进行切换。

- [ ] **`androidx.compose.animation.Crossfade`**
    - **用途**: 一个轻量级的 Composable，专门用于在不同内容之间实现平滑的淡入淡出过渡效果。

- [ ] **`androidx.compose.foundation.lazy.LazyItemScope.animateItemPlacement`**
    - **用途**: 一个 `Modifier`，应用于 `LazyColumn` 或 `LazyRow` 的 `item` 中，当列表项因数据变动而改变位置时，自动应用动画。

## 拔尖版本 (高阶与交互)

- [ ] **手势驱动的动画 (Gesture-driven Animations)**
    - **用途**: 将手势输入（如拖拽、滑动）与动画状态相结合。
    - **关键 API**:
        - `androidx.compose.foundation.gestures.draggable`
        - `androidx.compose.material.swipeable` (在 Material 1 中) 或 `androidx.compose.foundation.gestures.detectDragGestures`
        - 通常与 `Animatable` 结合使用，以实现拖拽后的回弹、吸附或衰减（Fling）效果。

- [ ] **`androidx.compose.ui.layout.LookaheadLayout`**
    - **用途**: 一个高级布局 Composable，用于实现跨组件、跨层次的复杂共享元素过渡和布局动画。它允许在动画前后两个不同布局状态之间进行插值。

- [x] **底层动画物理学 (Low-level Animation Physics)**
    - **用途**: 直接使用底层的动画类来构建自定义的动画行为，而不是依赖预设的 `AnimationSpec`。
    - **关键 API**:
        - `androidx.compose.animation.core.TargetBasedAnimation`
        - `androidx.compose.animation.core.DecayAnimation` (例如 `splineBasedDecay`)
