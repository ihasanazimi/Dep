package ir.ha.dep.ui.fragment

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import ir.ha.dep.R
import ir.ha.dep.databinding.FragmentAnimationBinding
import ir.ha.dep.ui.BaseFragment
import ir.ha.dep.utility.extentions.showToast

class AnimationsFrg : BaseFragment() {

    private lateinit var activeAnim : Animation
    private lateinit var binding : FragmentAnimationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = getBinding(R.layout.fragment_animation,container!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        /** lottie animation properties */
        binding.lottieAnimationView.apply {
            setAnimation(R.raw.anim_file)
            repeatMode
            addAnimatorUpdateListener { valueAnimator -> // TODO }
            addAnimatorListener(object :Animator.AnimatorListener{
                override fun onAnimationStart(p0: Animator?) {

                }

                override fun onAnimationEnd(p0: Animator?) {

                }

                override fun onAnimationCancel(p0: Animator?) {

                }

                override fun onAnimationRepeat(p0: Animator?) {

                }
            })
        }


        /** Android Animations */
        binding.play.setOnClickListener{

                when (binding.toggleGroup.checkedButtonId) {

                    R.id.rotateAnimBtn -> {
                        RotateAnimation(0F, 360F, Animation.RELATIVE_TO_SELF.toFloat(), Animation.RELATIVE_TO_SELF.toFloat()).apply {
                            duration = 2000L
                            repeatCount = Animation.INFINITE
                            interpolator = AccelerateInterpolator()
                            activeAnim = this
                        }
                    }

                    R.id.scaleAnimBtn -> {
                        // 2X
                        ScaleAnimation(0F, 2F, 0F, 2F, Animation.RELATIVE_TO_SELF.toFloat(), Animation.RELATIVE_TO_SELF.toFloat()).apply {
                            duration = 2000L
                            repeatCount = Animation.INFINITE
                            interpolator = AccelerateInterpolator()
                            activeAnim = this
                        }

                    }

                    R.id.translateAnimBtn -> {
                        TranslateAnimation(0F, -200F, Animation.RELATIVE_TO_SELF.toFloat(), -1F).apply {
                            repeatCount = Animation.INFINITE
                            duration = 2000L
                            interpolator = AccelerateInterpolator()
                            activeAnim = this
                        }
                    }

                    R.id.alphaAnimBtn -> {
                        AlphaAnimation(0F, 1F).apply {
                            repeatCount = Animation.INFINITE
                            duration = 2000L
                            interpolator = AccelerateInterpolator()
                            activeAnim = this
                        }
                    }

                    R.id.setAnimBtn -> {
                        AnimationSet(true).apply {
                            interpolator = AccelerateInterpolator()
                            repeatCount = Animation.INFINITE
                            fillAfter = true
                            duration = 2000L
                            addAnimation(AlphaAnimation(0F, 1F))
                            addAnimation(RotateAnimation(0F, 360F, Animation.RELATIVE_TO_SELF.toFloat(), Animation.RELATIVE_TO_SELF.toFloat()))
                            addAnimation(ScaleAnimation(0F, 2F, 0F, 2F, Animation.RELATIVE_TO_SELF.toFloat(), Animation.RELATIVE_TO_SELF.toFloat()))
                            activeAnim = this
                        }
                    }

                    else -> showToast(binding.lottieAnimationView.context,"?????? ????????????")

                }
                binding.lottieAnimationView.startAnimation(activeAnim)
        }
    }
}
}